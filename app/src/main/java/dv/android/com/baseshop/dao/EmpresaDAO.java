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

import dv.android.com.baseshop.dto.EmpresaDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.IEmpresaDAO;

public class EmpresaDAO implements IEmpresaDAO {
    @Override
    public EmpresaDTO findByPk(EmpresaDTO entity) throws BaseException {
        EmpresaDTO filter = null;
        final List<EmpresaDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Empresa");
            databaseReference.child("empresa"+entity.getIdEmpresa())
                    .orderByChild("idEmpresa").equalTo(entity.getIdEmpresa());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(EmpresaDTO.class));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","EmpresaDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","EmpresaDAO.findByPk.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }

    @Override
    public List<EmpresaDTO> findByAll() throws BaseException {
        final List<EmpresaDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Empresa");

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj : dataSnapshot.getChildren()){
                                list.add(dataSnapshot.getValue(EmpresaDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.e("Error:","EmpresaDAO.findByAll.causa: "+databaseError.getMessage());
                        }
                    }
            );

            return list;

        }catch (Exception e){
            Log.e("Error:","EmpresaDAO.findByAll.causa: "+e.getMessage());
            throw new BaseException("base03",null);
        }
    }
}
