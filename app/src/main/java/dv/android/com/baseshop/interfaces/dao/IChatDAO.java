package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.ChatDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IChatDAO {
    ChatDTO findByPk(ChatDTO entity)throws BaseException;
    List<ChatDTO> findByCriteria(ChatDTO entity)throws BaseException;
    void save(ChatDTO entity)throws BaseException;
    void delete(ChatDTO entity)throws BaseException;
}
