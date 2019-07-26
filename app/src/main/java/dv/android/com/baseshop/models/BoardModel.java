package dv.android.com.baseshop.models;

import android.graphics.Bitmap;
import android.util.Log;

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
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.models.IBoardModel;

public class BoardModel implements IBoardModel {

    private IProductoDAO productoDao;
    private IBaseExceptionDAO baseExcepcionDao;
    private ICompraDAO compraDAO;

    public BoardModel(){
        productoDao = new ProductoDAO();
        baseExcepcionDao = new BaseExceptionDAO();
        compraDAO = new CompraDAO();
    }

    @Override
    public List<ProductoDTO> findByAll(final IOnBoardListener listener) throws Exception{
        List<ProductoDTO> list = null;

        try{
            list = productoDao.findByAll(listener);

            //Valida que la lista no este vacia.
            if(list==null || list.isEmpty()){
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws001), null);
            }

            return list;
        }catch (BaseException e){
            Log.e("Error:","BoardModel.findByAll.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","BoardModel.findByAll.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void validateShowCar(String imei, IOnBoardListener listener) throws Exception {
        CompraDTO filter = null;
        List<CompraDTO> list = null;

        try{
            //Valida que el imei no este vacio.
            if(imei==null || imei.trim().compareTo("")==0){
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws003), null);
            }

            filter = new CompraDTO();
            filter.setImei(imei);

            compraDAO.findCarritoOnBoardByImei(filter, listener);

        }catch (BaseException e){
            Log.e("Error:","BoardModel.validateShowCar.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","BoardModel.validateShowCar.causa: "+e.getMessage());
            throw e;
        }
    }

    @Override
    public void findImagenProducto(List<ProductoDTO> productos, final IOnBoardListener listener) throws Exception {

        try{

            if(productos==null || productos.isEmpty()){
                throw new BaseException(baseExcepcionDao.getMessage(R.string.ws005), null);
            }

            for(ProductoDTO producto : productos) {

                //Se consulta la imagen del producto.
                productoDao.findImagenProducto(producto, listener);
            }

        }catch (BaseException e){
            Log.e("Error:","BoardModel.findImagenProducto.causa: "+e.getMessage());
            throw  e;
        }catch (Exception e){
            Log.e("Error:","BoardModel.findImagenProducto.causa: "+e.getMessage());
            throw e;
        }
    }
}
