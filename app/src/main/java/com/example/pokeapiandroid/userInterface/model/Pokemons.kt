package com.example.pokeapiandroid.userInterface.model

data class Pokemons (
    //consumir la api de pokemon llamada "PokeApi"


    var id:Int = 0,
    var num:String? = null,
    var name:String? = null,
    var url: String? = null,
    var img:String? = null,
    var type:List<String>? = null,
    var height:String? = null,
    var weight:String? = null,
    var candy:String? = null,
    var candy_count:Int = 0,
    var egg:String? = null,
    var spawn_chance:Double = 0.toDouble(),
    var avg_spawn:Double = 0.toDouble(),
    var spawn_time:String? = null,
    var multipliers:List<Double>? = null,
    var weaknesses:List<String>? = null,
    var next_evolution:List<NextEvolution>? = null,
    var prev_evolution:List<PrevEvolution>? = null
)








