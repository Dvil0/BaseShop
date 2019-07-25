package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.InventarioDTO;

public interface IInventarioDAO {
    InventarioDTO findByPk(InventarioDTO entity)throws Exception;
    List<InventarioDTO> findByCriteria(InventarioDTO entity)throws Exception;
    void save(InventarioDTO entity)throws Exception;
    void delete(InventarioDTO entity)throws Exception;
}
