package com.endava.jguzman.jhonatan.model;

import android.os.AsyncTask;

import java.util.List;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;

public class ConsumePokemonApi extends AsyncTask<Void,Void,List<NamedApiResource>> {

    @Override
    protected List<NamedApiResource> doInBackground(Void... voids) {
        PokeApi pokeApis = new PokeApiClient();
        return pokeApis.getPokemonList(1,151).getResults();
    }

}
