package com.example.pokeapiandroid.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapiandroid.data.PokemonsData
import com.example.pokeapiandroid.domain.PokemonUseCase
import com.example.pokeapiandroid.userInterface.model.Pokemons

class PokeViewModel : ViewModel() {
    private  val pokemonDataSet = PokemonsData()

    private val listData = MutableLiveData<List<Pokemons>>()

    init {
        getListPokemons()
    }


    fun setListData(listaPokemons: List<Pokemons>) {
        listData.value = listaPokemons
    }

    fun getListPokemons():LiveData<List<Pokemons>>{
        return pokemonDataSet.getAllPokemons()
    }

    fun getlistPokemonsLiveData():LiveData<List<Pokemons>>{
        return listData
    }
}