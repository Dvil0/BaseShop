package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.UsuarioDTO;

public interface IUsuarioDAO {
    UsuarioDTO findByPk(UsuarioDTO entity)throws Exception;
    void save(UsuarioDTO entity)throws Exception;
    void delete(UsuarioDTO entity)throws Exception;
    List<UsuarioDTO> findByCriteria(UsuarioDTO entity) throws Exception;
}
