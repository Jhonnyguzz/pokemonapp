package com.endava.jguzman.jhonatan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.endava.jguzman.jhonatan.model.ConsumePokemonApi;
import com.endava.jguzman.jhonatan.model.Pokemon;
import com.endava.jguzman.jhonatan.model.RVAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ConsumePokemonApi consumePokemonApi;

    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.list_of_pokemon);

        consumePokemonApi = new ConsumePokemonApi();
        consumePokemonApi.execute();

        pokemonList = new ArrayList<>();

        try {
            for (NamedApiResource pokemon: consumePokemonApi.get()) {
                //textView.append(pokemon.getName() + "\n");
                pokemonList.add(new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getCategory()));
            }
        } catch (InterruptedException e) {
            textView.append("Se interrumpio el hilo principal" + "\n");
        } catch (ExecutionException e) {
            textView.append("No hay internet prro" + "\n");
        }

        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        rv.setAdapter(new RVAdapter(pokemonList));

    }

}

