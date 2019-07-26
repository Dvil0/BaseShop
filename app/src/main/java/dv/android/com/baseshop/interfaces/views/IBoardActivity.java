package dv.android.com.baseshop.interfaces.views;

import android.graphics.Bitmap;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;

public interface IBoardActivity {

    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<ProductoDTO> productos);
    void setCarritoNoData();
    void setCarritoData();
    String getTelImei();
    void setPhoto();

}
