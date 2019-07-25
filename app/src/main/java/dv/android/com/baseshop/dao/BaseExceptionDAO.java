package dv.android.com.baseshop.dao;

import android.content.Context;
import android.util.Log;

import dv.android.com.baseshop.interfaces.dao.IBaseExceptionDAO;
import dv.android.com.baseshop.utils.AppContext;

public class BaseExceptionDAO implements IBaseExceptionDAO {
    @Override
    public String getMessage(int idException) throws Exception {
        String message;

        try {
            message = AppContext.context.getString(idException);

            return message;
        }catch (Exception e){
            Log.e("Error","BaseExceptionDAO.getMessage.causa: "+e.getMessage());
            throw e;
        }
    }
}
