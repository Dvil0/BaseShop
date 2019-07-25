package dv.android.com.baseshop.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import dv.android.com.baseshop.views.Fragments.MainTopFragment;

public class BoardActivity extends AppCompatActivity implements IBoardActivity,
        MainTopFragment.OnFragmentInteractionListener{

    private MainTopFragment mainTopFragment;
    private MainContainFragment mainContainFragment;
    private ItemProductsFragment itemProductsFragment;
    private ItemProductsAdapter itemProductsAdapter;
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

        boardPresenter = new BoardPresenter(this);

        //Se consulta todos los productos de la Bd.
        List<ProductoDTO> productos = null;
        productos = boardPresenter.findByAll();

        //Se organiza la lista de productos en el fragment.
        fragmentContain.setLayoutManager(new GridLayoutManager(this, 2));


        //Asigna los fragments al activity.
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentTop, mainTopFragment).commit();
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
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
