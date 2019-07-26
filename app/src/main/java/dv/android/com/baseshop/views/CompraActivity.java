package dv.android.com.baseshop.views;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.presenters.ICompraPresenter;
import dv.android.com.baseshop.interfaces.views.ICompraActivity;
import dv.android.com.baseshop.presenters.CompraPresenter;
import dv.android.com.baseshop.views.Adapters.ItemCompraAdapter;

public class CompraActivity extends AppCompatActivity implements ICompraActivity {

    private ICompraPresenter compraPresenter;
    private List<CompraDTO> carritoCompras;
    private RecyclerView recycler;

    private ItemCompraAdapter itemCompraAdapter;

    private TextView txtPrecioTotal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        //Inicializa el recycler para la lista de productos del carrito.
        recycler = findViewById(R.id.fragmentCompras);
        txtPrecioTotal = findViewById(R.id.txtPrecioTotal);

        //Se organiza la lista de productos en el fragment.
        recycler.setLayoutManager(new LinearLayoutManager(this));

        compraPresenter = new CompraPresenter(this);

        //Se realiza la consulta del carrito.
        compraPresenter.findComprasByImei();

    }

    @Override
    public void sucessMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    /**
     * Metodo que finaliza la actividad.
     * @param view
     * @author Dv
     */
    public void goBack(View view){
        finish();
    }

    @Override
    public void setCarritoCompras(List<CompraDTO> compras) {
        this.carritoCompras = compras;

        //Se consulta los productos a mostrar en el activity.
        compraPresenter.findProductosByIdProducto(compras);
    }

    @Override
    public void setItemsProductsFragment(final List<ProductoDTO> productos) {
        itemCompraAdapter = new ItemCompraAdapter(productos);

        //Se adiciona el adaptador del recyclerView.
        recycler.setAdapter(itemCompraAdapter);

        //Calcula el precio total de los productos del carrito.
        compraPresenter.calculatePrecioTotal(productos);
    }

    @Override
    public String getTelImei() {
        String deviceUniqueId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceUniqueId;
    }

    @Override
    public void setPrecioTotal(String precioTotal){
        txtPrecioTotal.setText(precioTotal);
    }

}
