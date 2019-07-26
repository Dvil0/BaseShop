package dv.android.com.baseshop.interfaces.dao;


import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;
import dv.android.com.baseshop.interfaces.listeners.IOnProductListener;

public interface IProductoDAO {
    ProductoDTO findByPk(ProductoDTO entity)throws Exception;
    void save(ProductoDTO entity)throws Exception;
    void delete(ProductoDTO entity)throws Exception;
    List<ProductoDTO> findByCriteria(ProductoDTO entity) throws Exception;
    List<ProductoDTO> findByAll(final IOnBoardListener listener) throws Exception;
    void findProductosByIdProducto(final List<ProductoDTO> entities, final IOnCompraListener listener)throws Exception;
    void findImagenProducto(final ProductoDTO producto, final IOnBoardListener listener)throws Exception;
    void findImagenProducto(final ProductoDTO producto, final IOnProductListener listener)throws Exception;
    void findImagenProducto(final ProductoDTO producto, final IOnCompraListener listener) throws Exception;
}
