package dv.android.com.baseshop.interfaces.models;


import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;

public interface IBoardModel {
    List<ProductoDTO> findByAll(final IOnBoardListener listener) throws Exception;
    void validateShowCar(String imei, IOnBoardListener listener) throws Exception;
    void findImagenProducto(List<ProductoDTO> productos, final IOnBoardListener listener)throws Exception;
}
