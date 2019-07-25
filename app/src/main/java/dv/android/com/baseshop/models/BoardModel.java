package dv.android.com.baseshop.models;

import android.util.Log;

import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dao.BaseExceptionDAO;
import dv.android.com.baseshop.dao.ProductoDAO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.exception.BaseException;
import dv.android.com.baseshop.interfaces.dao.IBaseExceptionDAO;
import dv.android.com.baseshop.interfaces.dao.IProductoDAO;
import dv.android.com.baseshop.interfaces.listeners.IOnBoardListener;
import dv.android.com.baseshop.interfaces.models.IBoardModel;

public class BoardModel implements IBoardModel {

    private IProductoDAO productoDao;
    private IBaseExceptionDAO baseExcepcionDao;

    public BoardModel(){
        productoDao = new ProductoDAO();
        baseExcepcionDao = new BaseExceptionDAO();
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
}
