package com.example.pokeapiandroid.userInterface.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapiandroid.R


class AdaptadorCustom(list: List<Pokemons>) :
    RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var list: MutableList<Pokemons> = mutableListOf()

    var viewHolder: ViewHolder? = null

    init {
        this.list.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent?.context).inflate(R.layout.template, parent, false)
        viewHolder = ViewHolder(view)
        return viewHolder as ViewHolder

    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder.textViewPokemon.setText(list.get(position).name)


    }

    fun loadNewList(list:List<Pokemons>){
        this.list.addAll(list)
        notifyDataSetChanged()

    }
//-------------Clase aparte para el view Holder--------//
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var view = view
        val textViewPokemon =  view.findViewById<TextView>(R.id.infoPokemo)
        var pokemon: Pokemons? = null

        init {
            pokemon?.name = ""
            pokemon?.id = 0
        }




    }


}