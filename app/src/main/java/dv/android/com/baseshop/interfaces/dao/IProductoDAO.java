package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;

public interface IProductoDAO {
    public ProductoDTO findByPk(ProductoDTO entity)throws BaseException;
    public void create(ProductoDTO entity)throws BaseException;
    public void update(ProductoDTO entity)throws BaseException;
    public void delete(ProductoDTO entity)throws BaseException;
    public List<ProductoDTO> findByCriteria(ProductoDTO entity) throws BaseException;
}
