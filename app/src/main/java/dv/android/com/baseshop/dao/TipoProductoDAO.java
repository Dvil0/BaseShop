package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.TipoProductoDTO;
import dv.android.com.baseshop.interfaces.dao.ITipoProductoDAO;

public class TipoProductoDAO implements ITipoProductoDAO {
    @Override
    public TipoProductoDTO findByPk(TipoProductoDTO entity) throws Exception {
        TipoProductoDTO filter = null;
        final List<TipoProductoDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TipoProducto");
            databaseReference.child("tipoProducto"+entity.getIdTipoProducto())
                    .orderByChild("idTipoProducto").equalTo(entity.getIdTipoProducto());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(TipoProductoDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","TipoProductoDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","TipoProductoDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<TipoProductoDTO> findByAll() throws Exception {
        final List<TipoProductoDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TipoProducto");

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj : dataSnapshot.getChildren()){
                                list.add(dataSnapshot.getValue(TipoProductoDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","TipoProductoDAO.findByAll.causa: "+databaseError.getMessage());
                        }
                    }
            );

            return list;

        }catch (Exception e){
            Log.e("Error:","TipoProductoDAO.findByAll.causa: "+e.getMessage());
            throw e;
        }
    }
}
