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
import dv.android.com.baseshop.entities.ProductoDTO;

public class ItemCompraAdapter extends RecyclerView.Adapter<ItemCompraAdapter.ViewHolderDatos>
        implements View.OnClickListener{

    private List<ProductoDTO> productoList;
    private View.OnClickListener listener;

    public ItemCompraAdapter(List<ProductoDTO> list){
        this.productoList = list;
    }

    @Override
    public ItemCompraAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_compra, null, false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCompraAdapter.ViewHolderDatos holder, int position) {
        if(productoList!=null && !productoList.isEmpty()) {
            DecimalFormat format = new DecimalFormat("#,##0");
            String decimal = format.format(productoList.get(position).getPrecio())+" CP";

            holder.txtNombreProductoCompra.setText(productoList.get(position).getNombre());
            holder.txtDescripcionCompra.setText(productoList.get(position).getDescripcion());
            holder.txtValorCompra.setText(decimal);
        }
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{

        private TextView txtNombreProductoCompra;
        private TextView txtDescripcionCompra;
        private TextView txtValorCompra;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txtNombreProductoCompra = itemView.findViewById(R.id.txtNombreProductoCompra);
            txtDescripcionCompra = itemView.findViewById(R.id.txtDescripcionCompra);
            txtValorCompra = itemView.findViewById(R.id.txtValorCompra);
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
