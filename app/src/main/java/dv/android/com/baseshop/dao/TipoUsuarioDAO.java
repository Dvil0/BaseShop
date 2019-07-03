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

import dv.android.com.baseshop.dto.TipoUsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.ITipoUsuarioDAO;

public class TipoUsuarioDAO implements ITipoUsuarioDAO {
    @Override
    public TipoUsuarioDTO findByPk(TipoUsuarioDTO entity) throws BaseException {
        TipoUsuarioDTO filter = null;
        final List<TipoUsuarioDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TipoUsuario");
            databaseReference.child("tipoUsuario"+entity.getIdTipoUsuario())
                    .orderByChild("idTipoUsuario").equalTo(entity.getIdTipoUsuario());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(TipoUsuarioDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","TipoUsuarioDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","TipoUsuarioDAO.findByPk.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public List<TipoUsuarioDTO> findByAll() throws BaseException {
        final List<TipoUsuarioDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("TipoUsuario");

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj : dataSnapshot.getChildren()){
                                list.add(dataSnapshot.getValue(TipoUsuarioDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","TipoUsuarioDAO.findByAll.causa: "+databaseError.getMessage());
                        }
                    }
            );

            return list;

        }catch (Exception e){
            Log.e("Error:","TipoUsuarioDAO.findByAll.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }
}
