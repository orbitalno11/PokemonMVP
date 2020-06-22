package io.github.orbitalno11.pokemonapimvp.models

import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseItem

data class PokemonLess(
    var name: String = "",
    var url: String = ""
): BaseItem()