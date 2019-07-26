package dv.android.com.baseshop.interfaces.listeners;

import android.graphics.Bitmap;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;

public interface IOnBoardListener {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<ProductoDTO> productos);
    void setCarritoNoData();
    void setCarridoData();
    void setPhoto();
}
