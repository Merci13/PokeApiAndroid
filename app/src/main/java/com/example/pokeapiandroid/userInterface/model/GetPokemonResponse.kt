package com.example.pokeapiandroid.userInterface.model

data  class GetPokemonResponse(
/*
* data class para almacenar la informacion brindada por la Poke Api
*
* data class for save the information given from Poke Api
*
* */

    var count : Int = 0,
    var next : String = "",
    var previous : String = "",
    var results : List<Pokemons>
)

