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

import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.interfaces.dao.IProductoDAO;

public class ProductoDAO implements IProductoDAO {
    @Override
    public ProductoDTO findByPk(ProductoDTO entity) throws Exception {
        ProductoDTO filter = null;
        final List<ProductoDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Producto");
            databaseReference.child("producto"+entity.getIdProducto())
                    .orderByChild("idProducto").equalTo(entity.getIdProducto());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(ProductoDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","ProductoDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","ProductoDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(ProductoDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Producto");
            databaseReference.child("producto"+entity.getIdProducto()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","ProductoDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(ProductoDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Producto");
            databaseReference.child("producto"+entity.getIdProducto()).removeValue();
        }catch (Exception e){
            Log.e("Error","ProductoDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ProductoDTO> findByCriteria(ProductoDTO entity) throws Exception {
        final List<ProductoDTO> dataList = new ArrayList<>();
        List<ProductoDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Producto");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(ProductoDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","ProductoDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(ProductoDTO obj : dataList){

                    if(entity.getIdProducto()!=null && obj.getIdProducto().compareTo(entity.getIdProducto())==0){
                        filterList.add(obj);
                    }
                    if(entity.getNombre()!=null && obj.getNombre().compareTo(entity.getNombre())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","ProductoDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }
}
