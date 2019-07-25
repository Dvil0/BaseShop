package dv.android.com.baseshop.views;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dv.android.com.baseshop.R;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private TextView txtCedula;
    private TextView txtPrimerNombre;
    private TextView txtSegundoNombre;
    private TextView txtPrimerApellido;
    private TextView txtSegundoApellido;
    private TextView txtAlias;
    private CalendarView calFechaNacimiento;
    private Spinner spnGenero;
    private TextView txtEmail;
    private Spinner spnTipoUsuario;
    private Spinner spnRol;
    private Spinner spnEmpresa;
    private TextView txtDireccion;
    private ImageView imgPerfil;
    private TextView txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtCedula = findViewById(R.id.txtCedula);
        //TODO Dv: Asignar el resto de objetos.
        //txtPrimerNombre;
        //txtSegundoNombre;
        //txtPrimerApellido;
        //txtSegundoApellido;
        //txtAlias;
        //calFechaNacimiento;
        //spnGenero;
        //txtEmail;
        //spnTipoUsuario;
        //spnRol;
        //spnEmpresa;
        //txtDireccion;
        //imgPerfil;
        //txtClave;
    }

}
