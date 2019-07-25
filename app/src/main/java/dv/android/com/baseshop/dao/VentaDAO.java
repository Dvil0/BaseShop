package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.VentaDTO;
import dv.android.com.baseshop.interfaces.dao.IVentaDTO;

public class VentaDAO implements IVentaDTO {
    @Override
    public VentaDTO findByPk(VentaDTO entity) throws Exception {
        VentaDTO filter = null;
        final List<VentaDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Venta");
            databaseReference.child("venta"+entity.getIdVenta())
                    .orderByChild("idVenta").equalTo(entity.getIdVenta());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(VentaDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","VentaDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","VentaDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<VentaDTO> findByCriteria(VentaDTO entity) throws Exception {
        final List<VentaDTO> dataList = new ArrayList<>();
        List<VentaDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Venta");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(VentaDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error","VentaDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(VentaDTO obj : dataList){

                    if(entity.getIdVenta()!=null && obj.getIdVenta().compareTo(entity.getIdVenta())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","VentaDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(VentaDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Venta");
            databaseReference.child("venta"+entity.getIdVenta()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","VentaDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(VentaDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Venta");
            databaseReference.child("venta"+entity.getIdVenta()).removeValue();
        }catch (Exception e){
            Log.e("Error","VentaDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }
}
