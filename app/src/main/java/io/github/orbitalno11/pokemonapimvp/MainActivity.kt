package io.github.orbitalno11.pokemonapimvp

import androidx.recyclerview.widget.LinearLayoutManager
import io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList.PokemonListAdapter
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpActivity
import io.github.orbitalno11.pokemonapimvp.ui.home.Home
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<MainActivityInterface.Presenter>(),
    MainActivityInterface.View {

    private lateinit var pokemonAdapter: PokemonListAdapter

    override fun createPresenter(): MainActivityInterface.Presenter {
        return MainActivityPresenter.create()
    }

    override fun getLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun bindView() {
        // bind view to kotlin
    }

    override fun setupInstance() {
        // setup component action such as onClickListener, set pager adapter
//        button.setOnClickListener {
//            getPresenter().setupText("Hello")
//        }
//        pokemonAdapter = PokemonListAdapter()
    }

    override fun setupView() {
        // setup component view such as toolbar , view pager
//        rcv.layoutManager = LinearLayoutManager(this)
//        rcv.adapter = pokemonAdapter
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_host, Home.newInstance())
            .commit()
    }

    override fun initial() {
//        val items = ArrayList<PokemonLess>()
//        items.add(PokemonLess("DITTO"))
//        pokemonAdapter.setItems(items)
    }

    override fun changeText(str: String) {
//        textView.text = str
    }
}