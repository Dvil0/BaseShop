package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.entities.MensajeDTO;
import dv.android.com.baseshop.interfaces.dao.IMensajesDAO;

public class MensajeDAO implements IMensajesDAO {
    @Override
    public MensajeDTO findByPk(MensajeDTO entity) throws Exception {
        MensajeDTO filter = null;
        final List<MensajeDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Mensaje");
            databaseReference.child("mensaje"+entity.getIdChat())
                    .orderByChild("idMensaje").equalTo(entity.getIdChat());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(MensajeDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","MensajeDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","MensajeDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<MensajeDTO> findByCriteria(MensajeDTO entity) throws Exception {
        final List<MensajeDTO> dataList = new ArrayList<>();
        List<MensajeDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Mensaje");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(MensajeDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","MensajeDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(MensajeDTO obj : dataList){

                    if(entity.getIdMensaje()!=null && obj.getIdMensaje().compareTo(entity.getIdMensaje())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdChat()!=null && obj.getIdChat().compareTo(entity.getIdChat())==0){
                        filterList.add(obj);
                    }
                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","MensajeDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(MensajeDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Mensaje");
            databaseReference.child("mensaje"+entity.getIdChat()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","MensajeDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(MensajeDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Mensaje");
            databaseReference.child("mensaje"+entity.getIdChat()).removeValue();
        }catch (Exception e){
            Log.e("Error","MensajeDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }
}
