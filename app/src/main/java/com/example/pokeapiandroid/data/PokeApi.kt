package com.example.pokeapiandroid.data

import com.example.pokeapiandroid.userInterface.model.GetPokemonResponse
import com.example.pokeapiandroid.userInterface.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApi{
/*
* Interface que va a la url https://pokeapi.co/api/v2/ y consulta por los pokemons que
*  se encuentren, obtiene la informacion y la devuelve en la funcion getAllPokemons()
*
*
*Interface that will consult the url https://pokeapi.co/api/v2/ and get all pokemons that it found,
* obtain the data and returned through the function getAllPokemons()

*/

    //Obtener todos los pokemons
    @GET("pokemon/")
    fun getAllPokemons():Call<GetPokemonResponse>

    //Obtener un solo pokemon
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id: Int):Call<Pokemons>


}