package dv.android.com.baseshop.interfaces.presenters;

import android.graphics.Bitmap;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;

public interface IBoardPresenter {
    List<ProductoDTO> findByAll();
    void validateShowCar();
    void findImagenProducto(List<ProductoDTO> productos);
}
