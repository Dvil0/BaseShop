package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IProductoDAO {
    ProductoDTO findByPk(ProductoDTO entity)throws BaseException;
    void save(ProductoDTO entity)throws BaseException;
    void delete(ProductoDTO entity)throws BaseException;
    List<ProductoDTO> findByCriteria(ProductoDTO entity) throws BaseException;
}
