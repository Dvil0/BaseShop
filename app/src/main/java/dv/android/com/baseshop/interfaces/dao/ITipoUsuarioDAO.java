package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.TipoUsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface ITipoUsuarioDAO {
    TipoUsuarioDTO findByPk(TipoUsuarioDTO entity)throws BaseException;
    List<TipoUsuarioDTO> findByAll()throws BaseException;
}
