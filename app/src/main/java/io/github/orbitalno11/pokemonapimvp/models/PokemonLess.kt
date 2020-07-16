package io.github.orbitalno11.pokemonapimvp.models

import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseItem

data class PokemonLess(
    var count: Double = 0.0,
    var next: String = "",
    var previous: String = "",
    var results: List<HashMap<String, String>> = emptyList()
): BaseItem()