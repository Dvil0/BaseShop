package dv.android.com.baseshop.dao;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.dto.ChatDTO;
import dv.android.com.baseshop.interfaces.dao.IChatDAO;

public class ChatDAO implements IChatDAO {
    @Override
    public ChatDTO findByPk(ChatDTO entity) throws Exception {
        ChatDTO filter = null;
        final List<ChatDTO> list = new ArrayList<>();

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Chat");
            databaseReference.child("chat"+entity.getIdChat())
                    .orderByChild("idChat").equalTo(entity.getIdChat());

            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            list.add(dataSnapshot.getValue(ChatDTO.class));
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","ChatDAO.findByPk.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!list.isEmpty()){
                filter = list.get(0);
            }
            return filter;

        }catch (Exception e){
            Log.e("Error:","ChatDAO.findByPk.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ChatDTO> findByCriteria(ChatDTO entity) throws Exception {
        final List<ChatDTO> dataList = new ArrayList<>();
        List<ChatDTO> filterList = null;

        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Chat");
            ValueEventListener valueEventListener = databaseReference.addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot obj: dataSnapshot.getChildren()){
                                dataList.add(obj.getValue(ChatDTO.class));
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e("Error:","ChatDAO.findByCriteria.causa: "+databaseError.getMessage());
                        }
                    }
            );

            if(!dataList.isEmpty()){
                filterList =  new ArrayList<>();

                for(ChatDTO obj : dataList){

                    if(entity.getIdChat()!=null && obj.getIdChat().compareTo(entity.getIdChat())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdUsuarioSolicita()!=null && obj.getIdUsuarioSolicita().compareTo(entity.getIdUsuarioSolicita())==0){
                        filterList.add(obj);
                    }

                    if(entity.getIdUsuarioResponde()!=null && obj.getIdUsuarioResponde().compareTo(entity.getIdUsuarioResponde())==0){
                        filterList.add(obj);
                    }

                }

            }
            return filterList;
        }catch (Exception e){
            Log.e("Error:","ChatDAO.findByCriteria.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(ChatDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Chat");
            databaseReference.child("chat"+entity.getIdChat()).setValue(entity);
        }catch (Exception e){
            Log.e("Error:","ChatDAO.save.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(ChatDTO entity) throws Exception {
        try{
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = firebaseDatabase.getReference("Chat");
            databaseReference.child("chat"+entity.getIdChat()).removeValue();
        }catch (Exception e){
            Log.e("Error","ChatDAO.delete.causa: "+e.getMessage());
            throw e;
        }
    }
}
