package dv.android.com.baseshop.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dto.ProductoDTO;
import dv.android.com.baseshop.interfaces.views.IProductActivity;

public class ProductActivity extends AppCompatActivity implements IProductActivity {

    private ProductoDTO productSelected;
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

            productSelected = (ProductoDTO) intent.getSerializableExtra("product");
            txtTitle = findViewById(R.id.txtTitle);
            txtDescription = findViewById(R.id.txtDescription);
            txtVendedor = findViewById(R.id.txtUserCrea);
            txtEstado = findViewById(R.id.txtEstado);
            txtPrecio = findViewById(R.id.txtPrecio);

            //Asigna la informacion a los campos del activity.
            txtTitle.setText(productSelected.getNombre());
            txtDescription.setText(productSelected.getDescripcion());
            txtVendedor.setText(productSelected.getUsuarioCrea());
            txtEstado.setText(productSelected.getEstado().compareTo("A")==0?"Disponible":"No disponible");

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
        //TODO DV: Implementar.
    }

    @Override
    public void sucessMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
