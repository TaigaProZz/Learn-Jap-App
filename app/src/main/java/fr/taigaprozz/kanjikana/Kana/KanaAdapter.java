package fr.taigaprozz.kanjikana.Kana;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import fr.taigaprozz.R;

public class KanaAdapter extends RecyclerView.Adapter<KanaAdapter.KanaViewHolder>{
    List<Kana> listeKana;

    public static class KanaViewHolder extends RecyclerView.ViewHolder{
        ImageView kana;
        public KanaViewHolder(View itemView) {
            super(itemView);
            kana = itemView.findViewById(R.id.kana);
        }
    }

    public KanaAdapter(List<Kana> listeKana) {
        this.listeKana = listeKana;
    }

    @NotNull
    @Override
    public KanaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_kana_adapter, parent, false);
        return new KanaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KanaViewHolder holder, int position) {
        Kana kana = listeKana.get(position);
        holder.kana.setImageResource (kana.getKana ());
    }

    @Override
    public int getItemCount() {
        return listeKana.size();
    }
}




