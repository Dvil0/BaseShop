package dv.android.com.baseshop.models;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dao.BaseExceptionDAO;
import dv.android.com.baseshop.dao.CompraDAO;
import dv.android.com.baseshop.dao.ProductoDAO;
import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.entities.UsuarioDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.IBaseExceptionDAO;
import dv.android.com.baseshop.interfaces.dao.ICompraDAO;
import dv.android.com.baseshop.interfaces.dao.IProductoDAO;
import dv.android.com.baseshop.interfaces.listeners.IOnProductListener;
import dv.android.com.baseshop.interfaces.models.IProductModel;
import dv.android.com.baseshop.utils.Parameters;

public class ProductModel implements IProductModel {

    private IProductoDAO productoDAO;
    private IBaseExceptionDAO baseExcepcionDao;
    private ICompraDAO compraDAO;

    public ProductModel(){
        productoDAO = new ProductoDAO();
        baseExcepcionDao = new BaseExceptionDAO();
        compraDAO = new CompraDAO();
    }

    @Override
    public void addToCar(ProductoDTO producto, UsuarioDTO usuario, final IOnProductListener listener) throws Exception {
        CompraDTO carrito = null;
        DateFormat format = null;

        try{

            if(producto.getEstado().compareTo(Parameters.NO_DISPONIBLE)==0){
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws002), null);
            }

            carrito = new CompraDTO();
            carrito.setIdProducto(producto.getIdProducto());
            carrito.setComprado(Parameters.NO);

            if(usuario!=null) {
                carrito.setUsuarioCrea(usuario.getUserId());
                carrito.setIdUsuario(usuario.getIdUsuario());
            }

            //Se asigna el IMEI del dispositivo.
            String imei = listener.getTelImei();
            carrito.setImei(imei);

            //Se asigna la fecha actual.
            format = new SimpleDateFormat("dd/MM/yyyy");
            carrito.setFechaCreacion(format.format(new Date()));

            //Se crea el registro del carrito.
            compraDAO.save(carrito);


        }catch (BaseException e){
            Log.e("Error:","ProductModel.addToCar.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","ProductModel.addToCar.causa: "+e.getMessage());
            throw e;
        }
    }
}
