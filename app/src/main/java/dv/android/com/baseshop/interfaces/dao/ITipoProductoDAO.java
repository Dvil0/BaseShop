package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.TipoProductoDTO;

public interface ITipoProductoDAO {
    TipoProductoDTO findByPk(TipoProductoDTO entity)throws Exception;
    List<TipoProductoDTO> findByAll()throws Exception;
}
