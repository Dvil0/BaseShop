package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.InventarioDTO;
import dv.android.com.baseshop.interfaces.dao.IInventarioDAO;

public class InventarioDAO implements IInventarioDAO {
    @Override
    public InventarioDTO findByPk(InventarioDTO entity) throws Exception {
        InventarioDTO filter = null;
        final List<InventarioDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Inventario");
            databaseReference.child("inventario"+entity.getIdInventario())
                    .orderByChild("idInventario").equalTo(entity.getIdInventario());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(InventarioDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","InventarioDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","InventarioDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<InventarioDTO> findByCriteria(InventarioDTO entity) throws Exception {
        final List<InventarioDTO> dataList = new ArrayList<>();
        List<InventarioDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Inventario");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(InventarioDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error","InventarioDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(InventarioDTO obj : dataList){

                    if(entity.getIdInventario()!=null && obj.getIdInventario().compareTo(entity.getIdInventario())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","InventarioDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(InventarioDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Inventario");
            databaseReference.child("inventario"+entity.getIdInventario()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","InventarioDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(InventarioDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Inventario");
            databaseReference.child("inventario"+entity.getIdInventario()).removeValue();
        }catch (Exception e){
            Log.e("Error","InventarioDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }
}
