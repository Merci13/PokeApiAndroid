package com.example.pokeapiandroid.data

import com.example.pokeapiandroid.userInterface.model.GetPokemonResponse
import com.example.pokeapiandroid.userInterface.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApi{
    //Url base https://pokeapi.co/api/v2/

    //Obtener todos los pokemons
    @GET("pokemon/")
    fun getAllPokemons():Call<GetPokemonResponse>

    //Obtener un solo pokemon
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id: Int):Call<Pokemons>


}