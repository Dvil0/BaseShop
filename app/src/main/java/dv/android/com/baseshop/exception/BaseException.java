package dv.android.com.baseshop.exception;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.utils.AppContext;

public class BaseException extends  Exception{

    private String message;



    public BaseException(String message,String [] datos){
        this.message=message;
        if(datos!=null && datos.length>0){
            try{
             for(int i=0;i<datos.length;i++){
                 message.replace("$EX"+(i+1),datos[i]);
             }
            }catch(Exception ex){
               message= AppContext.context.getResources().getString(R.string.base01);
            }

        }

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
