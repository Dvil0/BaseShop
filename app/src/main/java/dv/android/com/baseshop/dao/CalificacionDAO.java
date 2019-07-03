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

import dv.android.com.baseshop.dto.CalificacionDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.ICalificacionDAO;

public class CalificacionDAO implements ICalificacionDAO {
    @Override
    public CalificacionDTO findByPk(CalificacionDTO entity) throws BaseException {
        CalificacionDTO filter = null;
        final List<CalificacionDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Calificacion");
            databaseReference.child("calificacion"+entity.getIdCalificacion())
                    .orderByChild("idCalificacion").equalTo(entity.getIdCalificacion());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(CalificacionDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","CalificacionDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","CalificacionDAO.findByPk.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public List<CalificacionDTO> findByCriteria(CalificacionDTO entity) throws BaseException {
        final List<CalificacionDTO> dataList = new ArrayList<>();
        List<CalificacionDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Calificacion");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(CalificacionDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","CalificacionDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(CalificacionDTO obj : dataList){

                    if(entity.getIdCalificacion()!=null && obj.getIdCalificacion().compareTo(entity.getIdCalificacion())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdUsuarioCalifica()!=null && obj.getIdUsuarioCalifica().compareTo(entity.getIdUsuarioCalifica())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdUsuarioCalificado()!=null && obj.getIdUsuarioCalificado().compareTo(entity.getIdUsuarioCalificado())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","CalificacionDAO.findByCriteria.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void save(CalificacionDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Calificacion");
            databaseReference.child("calificacion"+entity.getIdCalificacion()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","CalificacionDAO.save.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void delete(CalificacionDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Calificacion");
            databaseReference.child("calificacion"+entity.getIdCalificacion()).removeValue();
        }catch (Exception e){
            Log.e("Error","CalificacionDAO.delete.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }
}
