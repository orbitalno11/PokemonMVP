package io.github.orbitalno11.pokemonapimvp.ui.home

import io.github.orbitalno11.pokemonapimvp.models.PokemonLess
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpInterface

interface HomeInterface {

    interface View : BaseMvpInterface.View {
        fun setupList(items: List<PokemonLess>)
    }

    interface Presenter : BaseMvpInterface.Presenter<View> {
        fun loadPokemonData()
    }
}