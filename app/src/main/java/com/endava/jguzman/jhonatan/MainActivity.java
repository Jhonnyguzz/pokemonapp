package com.endava.jguzman.jhonatan;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.endava.jguzman.jhonatan.model.ConsumePokemonApi;

import java.util.List;
import java.util.concurrent.ExecutionException;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ConsumePokemonApi consumePokemonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.list_of_pokemon);

        consumePokemonApi = new ConsumePokemonApi();
        consumePokemonApi.execute();

        try {
            for (NamedApiResource pokemon: consumePokemonApi.get()) {
                textView.append(pokemon.getName() + "\n");
            }
        } catch (InterruptedException e) {
            textView.append("Se interrumpio el hilo principal prro :v" + "\n");
        } catch (ExecutionException e) {
            textView.append("No hay internet prro :'v" + "\n");
        }

    }

}

