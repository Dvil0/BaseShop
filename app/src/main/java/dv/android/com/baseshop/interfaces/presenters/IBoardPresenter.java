package dv.android.com.baseshop.interfaces.presenters;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;

public interface IBoardPresenter {
    List<ProductoDTO> findByAll();
}
