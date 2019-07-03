package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.TipoProductoDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface ITipoProductoDAO {
    TipoProductoDTO findByPk(TipoProductoDTO entity)throws BaseException;
    List<TipoProductoDTO> findByAll()throws BaseException;
}
