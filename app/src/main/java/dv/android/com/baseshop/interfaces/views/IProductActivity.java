package dv.android.com.baseshop.interfaces.views;

import android.view.View;

public interface IProductActivity {
    void sucessMessage(String message);
    void errorMessage(String message);
    void goBack(View view);
    String getTelImei();
    void setPhoto();
}
