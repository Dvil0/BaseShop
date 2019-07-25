package dv.android.com.baseshop.views.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dto.ProductoDTO;

public class ItemProductsAdapter extends RecyclerView.Adapter<ItemProductsAdapter.ViewHolderDatos>
    implements View.OnClickListener{

    private List<ProductoDTO> productoList;
    private View.OnClickListener listener;

    public ItemProductsAdapter(List<ProductoDTO> list){
        this.productoList = list;
    }

    @Override
    public ItemProductsAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_list, null, false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemProductsAdapter.ViewHolderDatos holder, int position) {
        if(productoList!=null && !productoList.isEmpty()) {
            DecimalFormat format = new DecimalFormat("#,##0");
            String decimal = format.format(productoList.get(position).getPrecio())+" CP";

            holder.txtNombreProducto.setText(productoList.get(position).getNombre());
            holder.txtDescripcion.setText(productoList.get(position).getDescripcion());
            holder.txtValor.setText(decimal);
        }
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        private TextView txtNombreProducto;
        private TextView txtDescripcion;
        private TextView txtValor;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txtNombreProducto = itemView.findViewById(R.id.txtNombreProducto);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            txtValor = itemView.findViewById(R.id.txtValor);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }
}
