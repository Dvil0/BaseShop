package dv.android.com.baseshop.interfaces.views;

public interface IRegistroUsuarioActivity {
    void showErrorCedula(String message);
    void showErrorPrimerNombre(String message);
    void showErrorPrimerApellido(String message);
    void showErrorUserId(String message);
    void showErrorFechaNacimiento(String message);
    void showErrorGenero(String message);
    void showErrorEmail(String message);
    void showErrorTipoUsuario(String message);
    void showErrorRol(String message);
    void showErrorDireccion(String message);
    void showErrorImagenPerfil(String message);
    void showErrorClave(String message);
    void showErrorEmpresa(String message);

    void sucessMessage(String message);
    void errorMessage(String message);

    void goToHome();
}
