package dv.android.com.baseshop.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.presenters.IBoardPresenter;
import dv.android.com.baseshop.interfaces.views.IBoardActivity;
import dv.android.com.baseshop.presenters.BoardPresenter;
import dv.android.com.baseshop.views.Adapters.ItemProductsAdapter;
import dv.android.com.baseshop.views.Fragments.ItemProductsFragment;
import dv.android.com.baseshop.views.Fragments.MainContainFragment;
import dv.android.com.baseshop.views.Fragments.MainDockFragment;
import dv.android.com.baseshop.views.Fragments.MainTopFragment;

public class BoardActivity extends AppCompatActivity implements IBoardActivity,
        MainTopFragment.OnFragmentInteractionListener,
        MainDockFragment.OnFragmentInteractionListener {

    private MainTopFragment mainTopFragment;
    private MainContainFragment mainContainFragment;
    private ItemProductsFragment itemProductsFragment;
    private ItemProductsAdapter itemProductsAdapter;
    private MainDockFragment mainDockFragment;
    private RecyclerView fragmentContain;
    private IBoardPresenter boardPresenter;

    private List<ProductoDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //Inicializa los fragments.
        mainTopFragment = new MainTopFragment();
        fragmentContain = findViewById(R.id.fragmentContain);
        mainDockFragment = new MainDockFragment();

        boardPresenter = new BoardPresenter(this);

        //Se consulta todos los productos de la Bd.
        List<ProductoDTO> productos = null;
        productos = boardPresenter.findByAll();

        //Se organiza la lista de productos en el fragment.
        fragmentContain.setLayoutManager(new GridLayoutManager(this, 2));


        //Asigna los fragments al activity.
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentTop, mainTopFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentDock, mainDockFragment).commit();

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
    public void setItemsProductsFragment(final List<ProductoDTO> productos) {
        itemProductsAdapter = new ItemProductsAdapter(productos);

        //Se adiciona una accion a cada registro del recyclerView.
        itemProductsAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Seleccion:" +productos.get(fragmentContain.getChildAdapterPosition(v)).getNombre(),
                        Toast.LENGTH_SHORT).show();

                //Se muestra el detalle del producto seleccionado.
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("product",productos.get(fragmentContain.getChildAdapterPosition(v)));
                startActivity(intent);
            }
        });

        //Se adiciona el adaptador del recyclerView.
        fragmentContain.setAdapter(itemProductsAdapter);

        //Valida si tiene registros en el carrito para cambiar el modo del icono.
        boardPresenter.validateShowCar();
    }

    @Override
    public void setCarritoNoData() {
        mainDockFragment.setCarritoNoData();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDock,mainDockFragment);
    }

    @Override
    public void setCarritoData() {
        mainDockFragment.setCarritoData();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentDock,mainDockFragment);
    }

    @Override
    public String getTelImei() {
        String deviceUniqueId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceUniqueId;

    }

    /**
     * Metodo que lanza la actividad del carrito de compras.
     * @param view
     * @author Dv
     */
    public void goToCar(View view){

        //Valida que tenga datos en el carrito.
        if(mainDockFragment.getImgCarrito().getVisibility()==View.VISIBLE){
            sucessMessage(this.getString(R.string.msg_car_empty));
            return;
        }

        //Se lanza la actividad de compra del carrito.
        Intent intent = new Intent(this, CompraActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
