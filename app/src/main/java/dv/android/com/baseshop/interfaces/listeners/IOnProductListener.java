package dv.android.com.baseshop.interfaces.listeners;

import java.util.List;

public interface IOnProductListener {
    void sucessMessage(String message);
    void errorMessage(String message);
    String getTelImei();
    void setPhoto();
}
