package dv.android.com.baseshop.views.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import dv.android.com.baseshop.R;

public class MainDockFragment extends Fragment {

    private MainDockFragment.OnFragmentInteractionListener mListener;
    private ImageButton imgCarrito;
    private ImageButton imgCarritoOrange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dock_main,container,false);
        imgCarrito = view.findViewById(R.id.imgCarrito);
        imgCarritoOrange = view.findViewById(R.id.imgCarritoOrange);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Metodo que muestra el carrito
     * en el modo sin datos.
     * @author Dv
     */
    public void setCarritoNoData(){
        imgCarrito.setVisibility(View.VISIBLE);
        imgCarritoOrange.setVisibility(View.GONE);
    }

    /**
     * Metodo que muestra el carrito
     * en el modo con datos.
     * @author Dv
     */
    public void setCarritoData(){
        imgCarrito.setVisibility(View.GONE);
        imgCarritoOrange.setVisibility(View.VISIBLE);
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }

    public ImageButton getImgCarrito() {
        return imgCarrito;
    }

    public void setImgCarrito(ImageButton imgCarrito) {
        this.imgCarrito = imgCarrito;
    }
}
