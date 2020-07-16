package io.github.orbitalno11.pokemonapimvp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import io.github.orbitalno11.pokemonapimvp.api.PokemonApi
import io.github.orbitalno11.pokemonapimvp.models.Mars
import io.github.orbitalno11.pokemonapimvp.models.Pokemon
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.Exception

class HomePresenter: BaseMvpPresenter<HomeInterface.View>(), HomeInterface.Presenter {

    private val items = ArrayList<Pokemon>()

    // coroutine
    private var job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

//    FOR MVVM pattern
//    private val _response = MutableLiveData<String>()
//    val response: LiveData<String>
//        get() = _response

    companion object {
        fun create(): HomeInterface.Presenter{
            return HomePresenter()
        }
    }

    override fun loadPokemonData() {

        coroutineScope.launch {
            var getPokemon = PokemonApi.retrofitService.getPokemonList()
            try {
                var response = getPokemon.await()
                response.results.forEach {
                    val temp = Pokemon(name = it["name"]!!, url = it["url"]!!)
                    items.add(temp)
                }
            }catch (e: Exception){
                Log.d("POKEMON", "FAILED ${e.message}")
            }
            getView().setupList(items)
            println(items)
        }
    }
}