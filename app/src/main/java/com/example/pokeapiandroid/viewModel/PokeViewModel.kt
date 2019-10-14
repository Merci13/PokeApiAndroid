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

    fun getListPokemons():LiveData<List<Pokemons>> =/*obtener la porcion de la informacion que se va a utilizar
        en este caso, la api fragmenta la informacion en secciones de
        20 pokemons a la vez
        */
        /*
        * Obtein a porcion of data that it will be use in our aplication,
        * in this case, the api(POKE API) will fragment the data in chunks of 20 Pokemons at
        * the time
        * */

        pokemonDataSet.getAllPokemons()

    fun getlistPokemonsLiveData():LiveData<List<Pokemons>>{
        return listData
    }
}