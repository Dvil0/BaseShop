package dv.android.com.baseshop.interfaces.listeners;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dv.android.com.baseshop.dto.ProductoDTO;

public interface IOnBoardListener {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<ProductoDTO> productos);
}
