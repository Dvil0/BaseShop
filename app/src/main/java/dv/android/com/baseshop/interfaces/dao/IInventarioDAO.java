package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.InventarioDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IInventarioDAO {
    InventarioDTO findByPk(InventarioDTO entity)throws BaseException;
    List<InventarioDTO> findByCriteria(InventarioDTO entity)throws BaseException;
    void save(InventarioDTO entity)throws BaseException;
    void delete(InventarioDTO entity)throws BaseException;
}
