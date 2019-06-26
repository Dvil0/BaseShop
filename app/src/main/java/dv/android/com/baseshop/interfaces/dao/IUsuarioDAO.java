package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.UsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IUsuarioDAO {
    public UsuarioDTO findByPk(UsuarioDTO entity)throws BaseException;
    public void create(UsuarioDTO entity)throws BaseException;
    public void update(UsuarioDTO entity)throws BaseException;
    public void delete(UsuarioDTO entity)throws BaseException;
    public List<UsuarioDTO> findByCriteria(UsuarioDTO entity) throws BaseException;
}
