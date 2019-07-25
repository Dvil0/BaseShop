package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.TarjetaCreditoDTO;
import dv.android.com.baseshop.interfaces.dao.ITarjetaCreditoDAO;

public class TarjetaCreditoDAO implements ITarjetaCreditoDAO {
    @Override
    public TarjetaCreditoDTO findByPk(TarjetaCreditoDTO entity) throws Exception {
        TarjetaCreditoDTO filter = null;
        final List<TarjetaCreditoDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TarjetaCredito");
            databaseReference.child("tarjetaCredito"+entity.getIdTarjetaCredito())
                    .orderByChild("idTarjetaCredito").equalTo(entity.getIdTarjetaCredito());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(TarjetaCreditoDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","TarjetaCreditoDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","TarjetaCreditoDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<TarjetaCreditoDTO> findByCriteria(TarjetaCreditoDTO entity) throws Exception {
        final List<TarjetaCreditoDTO> dataList = new ArrayList<>();
        List<TarjetaCreditoDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TarjetaCredito");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(TarjetaCreditoDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error","TarjetaCreditoDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(TarjetaCreditoDTO obj : dataList){

                    if(entity.getIdTarjetaCredito()!=null && obj.getIdTarjetaCredito().compareTo(entity.getIdTarjetaCredito())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdUsuario()!=null && obj.getIdUsuario().compareTo(entity.getIdUsuario())==0){
                        filterList.add(obj);
                    }

                    if(entity.getNumeroTarjetaCredito()!=null && obj.getNumeroTarjetaCredito().compareTo(entity.getNumeroTarjetaCredito())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","TarjetaCreditoDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(TarjetaCreditoDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TarjetaCredito");
            databaseReference.child("tarjetaCredito"+entity.getIdTarjetaCredito()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","TarjetaCreditoDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(TarjetaCreditoDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TarjetaCredito");
            databaseReference.child("tarjetaCredito"+entity.getIdTarjetaCredito()).removeValue();
        }catch (Exception e){
            Log.e("Error","TarjetaCreditoDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }
}
