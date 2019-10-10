package com.example.pokeapiandroid.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.pokeapiandroid.R
import com.example.pokeapiandroid.userInterface.model.Pokemons
import com.example.pokeapiandroid.viewModel.PokeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)

        val pokemonObserver = Observer<List<Pokemons>>{listPokemons ->
            for (pokemon in listPokemons){
                    Log.d("Pokemon------->", pokemon.name )
            }
            for ((index : Int, value : Pokemons) in listPokemons.withIndex()){
                    Log.d("Pokemmon $index---->",value.name)
            }


        }
        viewModel.getlistPokemonsLiveData().observe(this,pokemonObserver)

    }
}//end of progra
