package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.interfaces.dao.ICompraDAO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;
import dv.android.com.baseshop.utils.Parameters;

public class CompraDAO implements ICompraDAO {

    @Override
    public void save(CompraDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");
            databaseReference.child("compra"+entity.getImei()+""+entity.getIdProducto()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","CompraDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(CompraDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");
            databaseReference.child("compra"+entity.getImei()+""+entity.getIdProducto()).removeValue();
        }catch (Exception e){
            Log.e("Error","CompraDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CompraDTO> findByCriteria(CompraDTO entity) throws Exception {
        final List<CompraDTO> dataList = new ArrayList<>();
        List<CompraDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");
            databaseReference.child("compra"+entity.getImei())
                    .orderByChild("comprado").equalTo(entity.getComprado());
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(CompraDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","CompraDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(CompraDTO obj : dataList){

                    if(entity.getIdUsuario()!=null && obj.getIdUsuario().compareTo(entity.getIdUsuario())==0){
                        filterList.add(obj);
                    }
                    if(entity.getImei()!=null && obj.getImei().compareTo(entity.getImei())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","CompraDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CompraDTO> findByAll(final IOnCompraListener listener) throws Exception {
        final List<CompraDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.clear();

                            for(DataSnapshot obj : dataSnapshot.getChildren()){
                                CompraDTO filter = obj.getValue(CompraDTO.class);
                                list.add(filter);


                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","CompraDAO.findByAll.causa: "+databaseError.getMessage());
                        }
                    }
            );

            return list;

        }catch (Exception e){
            Log.e("Error:","CompraDAO.findByAll.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void findCarritoOnBoardByImei(CompraDTO entity, final IOnBoardListener listener) throws Exception {
        final List<CompraDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");
            databaseReference.orderByChild("imei").equalTo(entity.getImei());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.clear();

                            for (DataSnapshot obj : dataSnapshot.getChildren()){
                                CompraDTO filter = obj.getValue(CompraDTO.class);

                                //Valida de que aun no se haya comprado.
                                if(filter.getComprado().compareTo(Parameters.NO)==0) {
                                    list.add(filter);
                                }
                            }

                            if(list!=null && !list.isEmpty()){
                                listener.setCarridoData();
                            }
                            else{
                                listener.setCarritoNoData();
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","CompraDAO.findCarritoOnBoardByImei.causa: "+databaseError.getMessage());
                        }
                    }
            );
        }catch (Exception e){
            Log.e("Error:","CompraDAO.findCarritoOnBoardByImei.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void findComprasOnComprasByImei(CompraDTO entity, final IOnCompraListener listener) throws Exception {
        final List<CompraDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Compra");
            databaseReference.orderByChild("imei").equalTo(entity.getImei());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.clear();

                            for (DataSnapshot obj : dataSnapshot.getChildren()){
                                CompraDTO filter = obj.getValue(CompraDTO.class);

                                //Valida de que aun no se haya comprado.
                                if(filter.getComprado().compareTo(Parameters.NO)==0) {
                                    list.add(filter);
                                }
                            }

                            if(list!=null && !list.isEmpty()){
                                listener.setCarritoCompras(list);
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","CompraDAO.findComprasOnComprasByImei.causa: "+databaseError.getMessage());
                        }
                    }
            );
        }catch (Exception e){
            Log.e("Error:","CompraDAO.findComprasOnComprasByImei.causa: "+e.getMessage());
            throw e;
        }
    }

}
