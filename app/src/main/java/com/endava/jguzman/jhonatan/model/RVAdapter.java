package com.endava.jguzman.jhonatan.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.endava.jguzman.jhonatan.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    private List<? extends Pokemon> pokemons;

    public RVAdapter(List<? extends Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int item) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        //holder.id.setText(String.valueOf(pokemons.get(position).getId()));
        holder.name.setText(pokemons.get(position).getName());
        //holder.category.setText(pokemons.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_view_layout);
            //id = itemView.findViewById(R.id.id_value);
            name = itemView.findViewById(R.id.pokemon_name);
            //category = itemView.findViewById(R.id.category_value);
        }
    }
}