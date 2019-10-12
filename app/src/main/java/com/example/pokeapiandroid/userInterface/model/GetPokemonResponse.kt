package com.example.pokeapiandroid.userInterface.model

data  class GetPokemonResponse(

    var count : Int = 0,
    var next : String = "",
    var previous : String = "",
    var results : List<Pokemons>
)

