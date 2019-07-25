package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.entities.RolDTO;
import dv.android.com.baseshop.interfaces.dao.IRolDAO;

public class RolDAO implements IRolDAO {
    @Override
    public RolDTO findByPk(RolDTO entity) throws Exception {
        RolDTO filter = null;
        final List<RolDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Rol");
            databaseReference.child("rol"+entity.getIdRol())
                    .orderByChild("idRol").equalTo(entity.getIdRol());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(RolDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","RolDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","RolDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<RolDTO> findByAll() throws Exception {
        final List<RolDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Rol");

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj : dataSnapshot.getChildren()){
                                list.add(dataSnapshot.getValue(RolDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","RolDAO.findByAll.causa: "+databaseError.getMessage());
                        }
                    }
            );

            return list;

        }catch (Exception e){
            Log.e("Error:","RolDAO.findByAll.causa: "+e.getMessage());
            throw e;
        }
    }
}
