package dv.android.com.baseshop.interfaces.views;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;

public interface IBoardActivity {

    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<ProductoDTO> productos);

}
