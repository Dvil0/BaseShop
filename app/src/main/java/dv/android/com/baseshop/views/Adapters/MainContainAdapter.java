package dv.android.com.baseshop.views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dto.ProductoDTO;

public class MainContainAdapter extends RecyclerView.Adapter<MainContainAdapter.ViewHolderDatos> {

    private List<ProductoDTO> productoList;

    public MainContainAdapter(List<ProductoDTO> list){
        this.productoList = list;
    }

    @Override
    public MainContainAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list, null, false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainContainAdapter.ViewHolderDatos holder, int position) {
        if(productoList!=null && !productoList.isEmpty()) {
            holder.asignarDato(productoList.get(position).getNombre());
        }
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        private EditText txtNombreProducto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
        }

        public void asignarDato(String name){
            txtNombreProducto.setText(name);
        }
    }

}
