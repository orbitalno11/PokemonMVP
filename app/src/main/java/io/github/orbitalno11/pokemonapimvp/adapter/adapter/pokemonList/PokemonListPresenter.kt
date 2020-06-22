package io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList

import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseListAdapterPresenter


class PokemonListPresenter : BaseListAdapterPresenter<PokemonListAdapterInterface.Adapter>(),
    PokemonListAdapterInterface.Presenter {

    companion object {
        fun create(): PokemonListAdapterInterface.Presenter{
            return PokemonListPresenter()
        }
    }

    override fun listClick() {
        getAdapter().clickLog()
    }
}