package dv.android.com.baseshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.entities.UsuarioDTO;
import dv.android.com.baseshop.interfaces.presenters.IProductPresenter;
import dv.android.com.baseshop.interfaces.views.IProductActivity;
import dv.android.com.baseshop.presenters.ProductPresenter;
import dv.android.com.baseshop.utils.Parameters;

public class ProductActivity extends AppCompatActivity implements IProductActivity {

    private IProductPresenter productPresenter;
    private ProductoDTO productSelected;
    private UsuarioDTO usuarioSesion;
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtVendedor;
    private TextView txtEstado;
    private TextView txtPrecio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //Se obtiene el request con el objeto a mostrar.
        Intent intent = getIntent();
        if(intent!=null){

            productPresenter = new ProductPresenter(this);
            productSelected = (ProductoDTO) intent.getSerializableExtra("product");
            usuarioSesion = (UsuarioDTO) intent.getSerializableExtra("user");

            txtTitle = findViewById(R.id.txtTitle);
            txtDescription = findViewById(R.id.txtDescription);
            txtVendedor = findViewById(R.id.txtUserCrea);
            txtEstado = findViewById(R.id.txtEstado);
            txtPrecio = findViewById(R.id.txtPrecio);

            //Asigna la informacion a los campos del activity.
            txtTitle.setText(productSelected.getNombre());
            txtDescription.setText(productSelected.getDescripcion());
            txtVendedor.setText(productSelected.getUsuarioCrea());
            txtEstado.setText(productSelected.getEstado().compareTo(Parameters.DISPONIBLE)==0?"Disponible":"No disponible");

            //Se convierte el formato del precio.
            DecimalFormat format = new DecimalFormat("#,##0");
            String decimal = "$"+format.format(productSelected.getPrecio())+" CP";
            txtPrecio.setText(decimal);
        }

    }

    /**
     * Metodo que finaliza la actividad.
     * @param view
     * @author Dv
     */
    public void goBack(View view){
        finish();
    }

    /**
     * Metodo que adiciona el producto
     * al carro de compras.
     * @param view
     * @author Dv
     */
    public void addToCar(View view){
        productPresenter.addToCar(productSelected, usuarioSesion);
    }

    @Override
    public void sucessMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public String getTelImei() {
        String deviceUniqueId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceUniqueId;

    }
}
