package dv.android.com.baseshop.interfaces.models;

import java.util.List;

import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;

public interface IBoardModel {
    List<ProductoDTO> findByAll(final IOnBoardListener listener) throws Exception;
}
