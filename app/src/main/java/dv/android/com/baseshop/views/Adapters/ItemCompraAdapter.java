package dv.android.com.baseshop.views.Adapters;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import dv.android.com.baseshop.R;
import dv.android.com.baseshop.dao.CompraDAO;
import dv.android.com.baseshop.entities.CompraDTO;
import dv.android.com.baseshop.entities.ProductoDTO;
import dv.android.com.baseshop.interfaces.dao.ICompraDAO;
import dv.android.com.baseshop.utils.AppContext;
import dv.android.com.baseshop.views.CompraActivity;

public class ItemCompraAdapter extends RecyclerView.Adapter<ItemCompraAdapter.ViewHolderDatos>
        implements View.OnClickListener{

    private Context context;
    private List<ProductoDTO> productoList;
    private View.OnClickListener listener;
    private ICompraDAO compraDAO;

    public ItemCompraAdapter(List<ProductoDTO> list, Context context){
        this.productoList = list;
        this.context = context;
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
            final int pos = position;
            DecimalFormat format = new DecimalFormat("#,##0");
            String decimal = format.format(productoList.get(position).getPrecio())+" CP";

            //Se adiciona los valores a los campos correspondientes.
            holder.txtNombreProductoCompra.setText(productoList.get(position).getNombre());
            holder.txtDescripcionCompra.setText(productoList.get(position).getDescripcion());
            holder.txtValorCompra.setText(decimal);
            holder.imgProductCompra.setImageBitmap(productoList.get(position).getPhoto());

            //Se le adiciona el evento de eliminacion de compra al boton de eliminar.
            holder.imgDeleteCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CompraDTO filter = null;

                    try{
                        compraDAO = new CompraDAO();

                        filter = new CompraDTO();
                        filter.setImei(getTelImei());
                        filter.setIdProducto(productoList.get(pos).getIdProducto());

                        //Se elimina la compra directamente.
                        compraDAO.delete(filter);
                        productoList.remove(pos);

                        if(productoList.size()<1){
                            ((CompraActivity)context).finish();
                        }

                        Toast.makeText(context, context.getString(R.string.msg_delete_compra),Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Log.e("Error","ItemCompraAdapter.delete.causa: "+e.getMessage());
                    }

                }
            });
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
        private ImageButton imgDeleteCompra;
        private ImageView imgProductCompra;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txtNombreProductoCompra = itemView.findViewById(R.id.txtNombreProductoCompra);
            txtDescripcionCompra = itemView.findViewById(R.id.txtDescripcionCompra);
            txtValorCompra = itemView.findViewById(R.id.txtValorCompra);
            imgDeleteCompra = itemView.findViewById(R.id.imgDeleteCompra);
            imgProductCompra = itemView.findViewById(R.id.imgProductCompra);
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

    /**
     * Retorna el imei del dispositivo.
     * @return
     * @author Dv
     */
    public String getTelImei() {
        String deviceUniqueId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceUniqueId;
    }
}
