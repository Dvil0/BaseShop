package dv.android.com.baseshop.dao;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.NotificacionDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.INotificacionDAO;

public class NotificacionDAO implements INotificacionDAO {
    @Override
    public NotificacionDTO findByPk(NotificacionDTO entity) throws BaseException {
        NotificacionDTO filter = null;
        final List<NotificacionDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Notificacion");
            databaseReference.child("notificacion"+entity.getIdNotificacion())
                    .orderByChild("idNotificacion").equalTo(entity.getIdNotificacion());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(NotificacionDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","NotificacionDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","NotificacionDAO.findByPk.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public List<NotificacionDTO> findByCriteria(NotificacionDTO entity) throws BaseException {
        final List<NotificacionDTO> dataList = new ArrayList<>();
        List<NotificacionDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Notificacion");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(NotificacionDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error","NotificacionDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(NotificacionDTO obj : dataList){

                    if(entity.getIdNotificacion()!=null && obj.getIdNotificacion().compareTo(entity.getIdNotificacion())==0){
                        filterList.add(obj);
                    }
                    if(entity.getIdUsuarioNotifica()!=null && obj.getIdUsuarioNotifica().compareTo(entity.getIdUsuarioNotifica())==0){
                        filterList.add(obj);
                    }
                    if(entity.getIdUsuarioNotificado()!=null && obj.getIdUsuarioNotificado().compareTo(entity.getIdUsuarioNotificado())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","NotificacionDAO.findByCriteria.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void save(NotificacionDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Notificacion");
            databaseReference.child("notificacion"+entity.getIdNotificacion()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","NotificacionDAO.save.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void delete(NotificacionDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Notificacion");
            databaseReference.child("notificacion"+entity.getIdNotificacion()).removeValue();
        }catch (Exception e){
            Log.e("Error","NotificacionDAO.delete.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }
}
