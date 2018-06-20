package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ender.terracota.R;

import java.util.List;

import models.Ato;

public class AtosAdapter extends RecyclerView.Adapter<AtosAdapter.AtosHolder>{

    private Context context;
    private List<Ato> listaAtos;

    public AtosAdapter(Context context, List<Ato> listaAtos) {
        this.context = context;
        this.listaAtos = listaAtos;
    }

    @NonNull
    @Override
    public AtosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_atos,parent,false);
        AtosHolder holder = new AtosHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AtosHolder holder, int position) {

        Ato ato = listaAtos.get(position);
        holder.tvNumAto.setText("Ato "+(position+1));
        holder.tvTituloAto.setText(ato.title);
        holder.tvDescricaoAto.setText(ato.description);

    }

    @Override
    public int getItemCount() {
        return listaAtos.size();
    }

    public class AtosHolder extends RecyclerView.ViewHolder{

        private TextView tvNumAto, tvTituloAto, tvDescricaoAto;

        public AtosHolder(View itemView) {
            super(itemView);

            tvNumAto = itemView.findViewById(R.id.tvNumAto);
            tvTituloAto = itemView.findViewById(R.id.tvTituloAto);
            tvDescricaoAto = itemView.findViewById(R.id.tvDescricaoAto);
        }
    }
}
