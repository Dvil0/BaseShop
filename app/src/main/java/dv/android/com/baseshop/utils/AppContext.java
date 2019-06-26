package dv.android.com.baseshop.utils;

import android.app.Application;

public class AppContext extends Application {

    public static Application context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = this;
    }
}
