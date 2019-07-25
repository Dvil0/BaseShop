package dv.android.com.baseshop.interfaces.dao;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;

public interface IProductoDAO {
    ProductoDTO findByPk(ProductoDTO entity)throws Exception;
    void save(ProductoDTO entity)throws Exception;
    void delete(ProductoDTO entity)throws Exception;
    List<ProductoDTO> findByCriteria(ProductoDTO entity) throws Exception;
    List<ProductoDTO> findByAll(final IOnBoardListener listener) throws Exception;
}
