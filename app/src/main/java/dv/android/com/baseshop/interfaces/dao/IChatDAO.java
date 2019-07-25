package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.ChatDTO;

public interface IChatDAO {
    ChatDTO findByPk(ChatDTO entity)throws Exception;
    List<ChatDTO> findByCriteria(ChatDTO entity)throws Exception;
    void save(ChatDTO entity)throws Exception;
    void delete(ChatDTO entity)throws Exception;
}
