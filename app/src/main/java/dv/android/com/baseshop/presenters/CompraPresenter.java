package dv.android.com.baseshop.presenters;

import android.util.Log;

import java.util.List;

import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;
import dv.android.com.baseshop.interfaces.models.ICompraModel;
import dv.android.com.baseshop.interfaces.presenters.ICompraPresenter;
import dv.android.com.baseshop.interfaces.views.ICompraActivity;
import dv.android.com.baseshop.models.CompraModel;

public class CompraPresenter implements ICompraPresenter,
        IOnCompraListener {

    private ICompraActivity compraView;
    private ICompraModel compraModel;

    public CompraPresenter(ICompraActivity compraView){
        this.compraView = compraView;
        this.compraModel = new CompraModel();
    }

    @Override
    public void sucessMessage(String message) {
        if(compraView!=null){
            compraView.sucessMessage(message);
        }
    }

    @Override
    public void errorMessage(String message) {
        if(compraView!=null){
            compraView.errorMessage(message);
        }
    }

    @Override
    public void findComprasByImei() {
        String imei = null;

        try{
            if(compraView!=null){
                //Consulta el imei del dispositivo para la consulta.
                imei = compraView.getTelImei();

                compraModel.findComprasByImei(imei, this);
            }
        }catch (BaseException e){
            Log.e("ERROR:","CompraPresenter.findComprasByImei.causa: "+e.getMessage());
            compraView.errorMessage(e.getMessage());
        }catch (Exception e){
            Log.e("ERROR:","CompraPresenter.findComprasByImei.causa: "+e.getMessage());
        }
    }

    @Override
    public void findProductosByIdProducto(List<CompraDTO> compras) {

        try{
            if(compraView!=null){
                compraModel.findProductosByIdProducto(compras,this);
            }
        }catch (BaseException e){
            Log.e("ERROR:","CompraPresenter.findProductosByIdProducto.causa: "+e.getMessage());
            compraView.errorMessage(e.getMessage());
        }catch (Exception e){
            Log.e("ERROR:","CompraPresenter.findProductosByIdProducto.causa: "+e.getMessage());
        }
    }

    @Override
    public void setCarritoCompras(List<CompraDTO> compras) {
        if(compraView != null){
            compraView.setCarritoCompras(compras);
        }
    }


    @Override
    public void setItemsProductsFragment(List<ProductoDTO> productos) {
        if(compraView!=null){
            compraView.setItemsProductsFragment(productos);
        }
    }

    @Override
    public void calculatePrecioTotal(List<ProductoDTO> productos) {
        try {
            if (compraView != null) {
                compraModel.calculatePrecioTotal(productos,this);
            }
        }catch (BaseException e){
            Log.e("ERROR:","CompraPresenter.calculatePrecioTotal.causa: "+e.getMessage());
            compraView.errorMessage(e.getMessage());
        }catch (Exception e){
            Log.e("ERROR:","CompraPresenter.calculatePrecioTotal.causa: "+e.getMessage());
        }
    }

    @Override
    public void setPrecioTotal(String precioTotal) {
        if(compraView!=null){
            compraView.setPrecioTotal(precioTotal);
        }
    }
}
