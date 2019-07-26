package dv.android.com.baseshop.models;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dao.BaseExceptionDAO;
import dv.android.com.baseshop.dao.CompraDAO;
import dv.android.com.baseshop.dao.ProductoDAO;
import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.IBaseExceptionDAO;
import dv.android.com.baseshop.interfaces.dao.ICompraDAO;
import dv.android.com.baseshop.interfaces.dao.IProductoDAO;
import dv.android.com.baseshop.interfaces.listeners.IOnCompraListener;
import dv.android.com.baseshop.interfaces.models.ICompraModel;
import dv.android.com.baseshop.utils.Parameters;

public class CompraModel implements ICompraModel {

    private IProductoDAO productoDao;
    private IBaseExceptionDAO baseExcepcionDao;
    private ICompraDAO compraDAO;

    public CompraModel(){
        productoDao = new ProductoDAO();
        baseExcepcionDao = new BaseExceptionDAO();
        compraDAO = new CompraDAO();
    }

    @Override
    public void findComprasByImei(String imei, final IOnCompraListener listener) throws Exception{
        CompraDTO filter = null;

        try {
            //Valida que el imei no este vacio.
            if (imei == null || imei.trim().compareTo("") == 0) {
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws003), null);
            }

            //Se consulta el carrito de compras con el imei.
            filter = new CompraDTO();
            filter.setImei(imei);

            compraDAO.findComprasOnComprasByImei(filter,listener);

        }catch (BaseException e){
        Log.e("Error:","CompraModel.findComprasByImei.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","CompraModel.findComprasByImei.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void findProductosByIdProducto(List<CompraDTO> compras, final IOnCompraListener listener)throws Exception {
        List<ProductoDTO> list = null;

        try{

            //Valida que la lista de compras no este vacia.
            if (compras == null || compras.isEmpty()) {
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws004), null);
            }

            list = new ArrayList<>();

            //Se recorre las compras para sacar los id's de productos.
            for(CompraDTO compra: compras){
                ProductoDTO filter = new ProductoDTO();
                filter.setIdProducto(compra.getIdProducto());

                list.add(filter);
            }

            //Se consultan los productos del carrito.
            productoDao.findProductosByIdProducto(list,listener);

        }catch (BaseException e){
            Log.e("Error:","CompraModel.findProductosByIdProducto.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","CompraModel.findProductosByIdProducto.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void calculatePrecioTotal(List<ProductoDTO> productos, IOnCompraListener listener) throws Exception {
        Long precioTotal = 0L;
        String decimal = null;

        try{

            //Valida que la lista de productos no este vacia.
            if (productos == null || productos.isEmpty()) {
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws001), null);
            }

            for(ProductoDTO producto : productos){
                precioTotal = precioTotal + producto.getPrecio();
            }

            DecimalFormat format = new DecimalFormat("#,##0");
            decimal = "$"+format.format(precioTotal)+" CP";

            //Muestra el precio total en el activty.
            listener.setPrecioTotal(decimal);

        }catch (BaseException e){
            Log.e("Error:","CompraModel.findProductosByIdProducto.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","CompraModel.findProductosByIdProducto.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void buyCar(List<CompraDTO> compras, IOnCompraListener listener) throws Exception {
        try{
            //Valida que la lista de compras no este vacia.
            if (compras == null || compras.isEmpty()) {
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws004), null);
            }

            //Se actualiza el estado de la compra.
            for (CompraDTO compra : compras){
                compra.setComprado(Parameters.YES);

                compraDAO.save(compra);
            }

        }catch (BaseException e){
            Log.e("Error:","CompraModel.buyCar.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","CompraModel.buyCar.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void findImagenProducto(List<ProductoDTO> productos, final IOnCompraListener listener) throws Exception {

        try{

            if(productos==null || productos.isEmpty()){
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws005), null);
            }

            for(ProductoDTO producto : productos) {

                //Se consulta la imagen del producto.
                productoDao.findImagenProducto(producto, listener);
            }

        }catch (BaseException e){
            Log.e("Error:","CompraModel.findImagenProducto.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","CompraModel.findImagenProducto.causa: "+e.getMessage());
            throw e;
        }
    }
}
