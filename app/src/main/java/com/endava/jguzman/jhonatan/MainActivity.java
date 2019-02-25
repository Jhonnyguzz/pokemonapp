package com.endava.jguzman.jhonatan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.endava.jguzman.jhonatan.model.ConsumePokemonApi;
import com.endava.jguzman.jhonatan.model.Pokemon;
import com.endava.jguzman.jhonatan.model.RVAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

public class MainActivity extends AppCompatActivity {

    private ConsumePokemonApi consumePokemonApi;

    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumePokemonApi = new ConsumePokemonApi();
        consumePokemonApi.execute();

        pokemonList = new ArrayList<>();

        try {
            for (NamedApiResource pokemon: consumePokemonApi.get()) {
                pokemonList.add(new Pokemon(pokemon.getId(), pokemon.getName(), pokemon.getCategory()));
            }

            RecyclerView rv = findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setHasFixedSize(true);
            rv.setAdapter(new RVAdapter(pokemonList));

        } catch (InterruptedException e) {
            throw new RuntimeException("Se ha interrumpido el hilo principal");
        } catch (ExecutionException e) {
            throw new RuntimeException("No hay internet");
        }

    }

}

