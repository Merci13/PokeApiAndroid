package com.example.pokeapiandroid.userInterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapiandroid.R
import com.example.pokeapiandroid.userInterface.model.AdaptadorCustom
import com.example.pokeapiandroid.userInterface.model.Pokemons
import com.example.pokeapiandroid.viewModel.PokeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PokeViewModel
    private  var list : RecyclerView? = null
    private  var layaoutManager:RecyclerView.LayoutManager? = null
    private  var adaptadorCustom:AdaptadorCustom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)
        adaptadorCustom = AdaptadorCustom(listOf())
        //Recycle View
        list = findViewById(R.id.pokemon)
        layaoutManager = LinearLayoutManager(this)
        list?.layoutManager = layaoutManager
       list?.adapter = adaptadorCustom

        //-----------------------------------------//
        val pokemonObserver = Observer<List<Pokemons>>{listPokemons ->
            for (pokemon in listPokemons){
                    Log.d("Pokemon------->", pokemon.name )
            }
            for ((index : Int, value : Pokemons) in listPokemons.withIndex()){
                    Log.d("Pokemmon $index---->",value.name)
            }
            adaptadorCustom?.loadNewList(listPokemons)//cargar nueva lista



        }
        viewModel.getListPokemons().observe(this,pokemonObserver)






    }
}//end of progra
