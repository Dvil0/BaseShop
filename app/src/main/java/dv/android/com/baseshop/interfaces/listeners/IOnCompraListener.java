package dv.android.com.baseshop.interfaces.listeners;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;

public interface IOnCompraListener {
    void sucessMessage(String message);
    void errorMessage(String message);
    void setItemsProductsFragment(List<CompraDTO> compras);
}
