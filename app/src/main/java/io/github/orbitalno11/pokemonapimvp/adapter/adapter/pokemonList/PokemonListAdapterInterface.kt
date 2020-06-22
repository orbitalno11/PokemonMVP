package io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList

import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseMvpListAdapterInterface

interface PokemonListAdapterInterface {

    interface Adapter: BaseMvpListAdapterInterface.Adapter{
        fun clickLog()
    }

    interface Presenter: BaseMvpListAdapterInterface.Presenter<Adapter>{
        fun listClick()
    }
}