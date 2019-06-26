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

import dv.android.com.baseshop.dto.UsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.IUsuarioDAO;

public class UsuarioDAO implements IUsuarioDAO {
    @Override
    public UsuarioDTO findByPk(UsuarioDTO entity) throws BaseException {
        UsuarioDTO filter = null;
        final List<UsuarioDTO> list = new ArrayList<UsuarioDTO>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Usuario");
            databaseReference.child("usuario"+entity.getCedula())
                    .orderByChild("cedula").equalTo(entity.getCedula());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                           //filter = dataSnapshot.getValue(UsuarioDTO.class);
                           list.add(dataSnapshot.getValue(UsuarioDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("findByPk.","causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(list!=null && !list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("UsusarioDAO.findByPk.","causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void create(UsuarioDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Usuario");
            databaseReference.child("usuario"+entity.getCedula()).setValue(entity);
        }catch (Exception e){
            Log.e("UsusarioDAO.create.","causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void update(UsuarioDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Usuario");
            databaseReference.child("usuario"+entity.getCedula()).setValue(entity);
        }catch (Exception e){
            Log.e("UsusarioDAO.update.","causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public void delete(UsuarioDTO entity) throws BaseException {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Usuario");
            databaseReference.child("usuario"+entity.getCedula()).removeValue();
        }catch (Exception e){
            Log.e("UsusarioDAO.delete.","causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public List<UsuarioDTO> findByCriteria(UsuarioDTO entity) throws BaseException {
        final List<UsuarioDTO> dataList = new ArrayList<UsuarioDTO>();
        List<UsuarioDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Usuario");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(UsuarioDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("findByCriteria.","causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<UsuarioDTO>();

                for(UsuarioDTO obj : dataList){

                    if(entity.getIdUsuario()!=null && obj.getIdUsuario().compareTo(entity.getIdUsuario())==0){
                        filterList.add(obj);
                    }
                    if(entity.getCedula()!=null && obj.getCedula().compareTo(entity.getCedula())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("UsusarioDAO.findByC.",""+e.getMessage());
            throw new BaseException("base03",null);
        }
    }
}
