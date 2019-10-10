package com.example.pokeapiandroid.domain

import com.example.pokeapiandroid.data.PokemonsData
import com.example.pokeapiandroid.userInterface.model.Pokemons

class PokemonUseCase {

    private  val pokemonDataSet = PokemonsData()

    fun getAllPokemons():List<Pokemons>{
        return pokemonDataSet.getAllPokemons()
    }

 }