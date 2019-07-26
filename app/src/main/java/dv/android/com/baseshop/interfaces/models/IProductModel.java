package dv.android.com.baseshop.interfaces.models;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.entities.UsuarioDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnProductListener;

public interface IProductModel {
    void addToCar(ProductoDTO producto, UsuarioDTO usuario, final IOnProductListener listener) throws Exception;
    void findImagenProducto(List<ProductoDTO> productos, final IOnProductListener listener)throws Exception;
}
