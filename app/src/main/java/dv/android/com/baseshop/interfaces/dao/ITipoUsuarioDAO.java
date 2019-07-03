package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.TipoUsuarioDTO;

public interface ITipoUsuarioDAO {
    TipoUsuarioDTO findByPk(TipoUsuarioDTO entity)throws Exception;
    List<TipoUsuarioDTO> findByAll()throws Exception;
}
