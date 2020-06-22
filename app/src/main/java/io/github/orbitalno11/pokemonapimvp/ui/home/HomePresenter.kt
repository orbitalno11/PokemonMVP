package io.github.orbitalno11.pokemonapimvp.ui.home

import android.util.Log
import io.github.orbitalno11.pokemonapimvp.api.PokemonApi
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter: BaseMvpPresenter<HomeInterface.View>(), HomeInterface.Presenter {

    private val items = ArrayList<PokemonLess>()

    companion object {
        fun create(): HomeInterface.Presenter{
            return HomePresenter()
        }
    }

    override fun loadPokemonData() {
        items.add(PokemonLess("Metagross"))
        items.add((PokemonLess("Flygon")))
        items.add((PokemonLess("Mew")))
        getView().setupList(items)

        PokemonApi.retrofitService.getPokemonList().enqueue(object : Callback<HashMap<String, Any>>{
            override fun onFailure(call: Call<HashMap<String, Any>>, t: Throwable) {
                Log.d("FETCH", "FAILED")
            }

            override fun onResponse(call: Call<HashMap<String, Any>>, response: Response<HashMap<String, Any>>) {
                val body = response.body()
                Log.d("FETCH", body.toString())
            }

        })
    }
}