package dv.android.com.baseshop.interfaces.presenters;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;

public interface ICompraPresenter {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<ProductoDTO> productos);
    void findComprasByImei() ;
    void findProductosByIdProducto(List<CompraDTO> compras);
    void calculatePrecioTotal(List<ProductoDTO> productos);
    void buyCar(List<CompraDTO> compras);
    void findImagenProducto(List<ProductoDTO> productos);
}
