package com.example.pokeapiandroid.data

import android.util.Log
import com.example.pokeapiandroid.userInterface.model.Pokemons
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class PokemonsData {
    //Url base https://pokeapi.co/api/v2/
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //crear el servicio para hacer las llamadas
    var service = retrofit.create<PokeApi>(PokeApi::class.java)


    fun getAllPokemons(): List<Pokemons> {
        val call: Call<List<Pokemons>> = service.getAllPokemons()
        val pokemons: List<Pokemons> = call.execute().body().orEmpty()
        Log.d("Pokemon---------->", pokemons.toString())
        return pokemons// se retorna una lista de pokemons

    }//end of getAllPokemons function

    fun getOnePokemon(id: Int) {
        var pokemon: Pokemons?
        service.getPokemonById(id).enqueue(object : Callback<Pokemons> {
            override fun onResponse(call: Call<Pokemons>?, response: Response<Pokemons>?) {
                pokemon = response?.body()
                Log.d("Pokemon", Gson().toJson(pokemon))
            }

            override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                t?.printStackTrace()
            }
        })

    }//end of getOnePokemon


}