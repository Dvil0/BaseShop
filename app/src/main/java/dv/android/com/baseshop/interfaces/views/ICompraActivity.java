package dv.android.com.baseshop.interfaces.views;

import android.view.View;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;

public interface ICompraActivity {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setCarritoCompras(List<CompraDTO> compras);
    String getTelImei();
    void setItemsProductsFragment(List<ProductoDTO> productos);
    void setPrecioTotal(String precioTotal);
    void goBack(View view);
    void setPhoto();
}
