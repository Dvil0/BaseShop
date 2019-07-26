package dv.android.com.baseshop.interfaces.models;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;

public interface ICompraModel {
    void findComprasByImei(String imei, final IOnCompraListener listener) throws Exception;
    void findProductosByIdProducto(List<CompraDTO> compras, final IOnCompraListener listener)throws Exception;
    void calculatePrecioTotal(List<ProductoDTO> productos, final IOnCompraListener listener)throws Exception;
    void buyCar(List<CompraDTO> compras, final IOnCompraListener listener)throws Exception;
    void findImagenProducto(List<ProductoDTO> productos, final IOnCompraListener listener)throws Exception;
}
