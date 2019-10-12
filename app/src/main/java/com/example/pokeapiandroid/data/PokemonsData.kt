package com.example.pokeapiandroid.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokeapiandroid.userInterface.model.GetPokemonResponse
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


    fun getAllPokemons(): LiveData<List<Pokemons>> {
        val response = MutableLiveData<List<Pokemons>>()
        val call: Call<GetPokemonResponse> = service.getAllPokemons()
       call.enqueue(object: Callback<GetPokemonResponse>{
            override fun onFailure(call: Call<GetPokemonResponse>, t: Throwable) {
                response.postValue(listOf())//se declara una lista en blanco
            }

            override fun onResponse(
                call: Call<GetPokemonResponse>,remoteResponse: Response<GetPokemonResponse>
            ) {
               response.postValue(remoteResponse.body()?.results.orEmpty())//obtiene el cuerpo el cual tiene el valor del response,
            }

        })

        return response// se retorna una lista de pokemons

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