package io.github.orbitalno11.pokemonapimvp.ui.home

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.orbitalno11.pokemonapimvp.R
import io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList.PokemonListAdapter
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpFragment

class Home : BaseMvpFragment<HomeInterface.Presenter>(), HomeInterface.View {

    private lateinit var pokemonAdapter: PokemonListAdapter
    private lateinit var rcv: RecyclerView

    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }

    override fun createPresenter(): HomeInterface.Presenter {
        return HomePresenter.create()
    }

    override fun getLayoutView(): Int {
        return R.layout.home_fragment
    }

    override fun bindView(view: View) {
        rcv = view.findViewById(R.id.pokemon_list)
    }

    override fun setupInstance() {
        pokemonAdapter = PokemonListAdapter()
    }

    override fun setupView() {
        rcv.layoutManager = LinearLayoutManager(context)
        rcv.adapter = pokemonAdapter
    }

    override fun initial() {
        getPresenter().loadPokemonData()
    }

    override fun setupList(items: List<PokemonLess>) {
        pokemonAdapter.setItems(items)
    }
}