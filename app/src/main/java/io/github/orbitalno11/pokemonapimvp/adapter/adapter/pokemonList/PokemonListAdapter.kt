package io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList

import android.util.Log
import android.view.View
import android.view.ViewGroup
import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseListAdapterView
import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseViewHolder
import io.github.orbitalno11.pokemonapimvp.models.Pokemon
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess

class PokemonListAdapter: BaseListAdapterView<BaseViewHolder, PokemonListAdapterInterface.Presenter>(), PokemonListAdapterInterface.Adapter {
    private var itemClickListener = View.OnClickListener{
        getPresenter().listClick()
    }

    override fun createPresenter(): PokemonListAdapterInterface.Presenter {
        return PokemonListPresenter.create()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return Holder(parent)
    }

    override fun getItemCount(): Int {
        return getPresenter().getItemCount()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val i = getPresenter().getItem(position)
        val item: Pokemon = i as Pokemon
        val hold: Holder = holder as Holder
        hold.setHolderClick(itemClickListener)
        hold.onBind(item)
    }

    override fun clickLog() {
        Log.d("ADAPTER", "ADAPTER CLICK")
    }

    override fun notifyDataSetChange() {
    }
}