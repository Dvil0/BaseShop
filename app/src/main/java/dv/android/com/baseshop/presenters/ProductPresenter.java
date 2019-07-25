package dv.android.com.baseshop.presenters;

import android.util.Log;

import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.entities.UsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.listeners.IOnProductListener;
import dv.android.com.baseshop.interfaces.models.IProductModel;
import dv.android.com.baseshop.interfaces.presenters.IProductPresenter;
import dv.android.com.baseshop.interfaces.views.IProductActivity;
import dv.android.com.baseshop.models.ProductModel;

public class ProductPresenter implements IProductPresenter,
        IOnProductListener{

    private IProductActivity productView;
    private IProductModel productModel;

    public ProductPresenter(IProductActivity productView){
        this.productView = productView;
        this.productModel = new ProductModel();
    }

    @Override
    public void addToCar(ProductoDTO producto, UsuarioDTO usuario) {
        try {
            if (productView != null) {
                productModel.addToCar(producto, usuario, this);
            }
        }catch (BaseException e){
            Log.e("ERROR:","ProductPresenter.findByAll.causa: "+e.getMessage());
            productView.errorMessage(e.getMessage());
        }catch (Exception e){
            Log.e("ERROR:","ProductPresenter.findByAll.causa: "+e.getMessage());
        }
    }

    @Override
    public void sucessMessage(String message) {
        if(productView!=null){
            productView.sucessMessage(message);
        }
    }

    @Override
    public void errorMessage(String message) {
        if(productView!=null){
            productView.errorMessage(message);
        }
    }

    @Override
    public String getTelImei() {
        String imei = null;

        if(productView!=null){
            productView.getTelImei();
        }

        return imei;
    }
}
