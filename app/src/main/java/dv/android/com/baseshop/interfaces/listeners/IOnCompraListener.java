package dv.android.com.baseshop.interfaces.listeners;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;

public interface IOnCompraListener {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setCarritoCompras(List<CompraDTO> compras);
    void setItemsProductsFragment(List<ProductoDTO> productos);
    void setPrecioTotal(String precioTotal);
    void setPhoto();
}
