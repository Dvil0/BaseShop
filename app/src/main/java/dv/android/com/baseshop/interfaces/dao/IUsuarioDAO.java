package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.UsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IUsuarioDAO {
    UsuarioDTO findByPk(UsuarioDTO entity)throws BaseException;
    void save(UsuarioDTO entity)throws BaseException;
    void delete(UsuarioDTO entity)throws BaseException;
    List<UsuarioDTO> findByCriteria(UsuarioDTO entity) throws BaseException;
}
