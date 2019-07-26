package dv.android.com.baseshop.interfaces.presenters;

import java.util.List;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.entities.UsuarioDTO;
import dv.android.com.baseshop.interfaces.listeners.IOnProductListener;

public interface IProductPresenter {
    /**
     * Metodo que adiciona el producto
     *      * al carrito de compras.
     * @param producto
     * @param usuario
     * @author Dv
     */
    void addToCar(ProductoDTO producto, UsuarioDTO usuario);

    /**
     * Retorna el IMEI del disposivito.
     * @return
     * @author Dv
     */
    String getTelImei();
    void findImagenProducto(List<ProductoDTO> productos);
}
