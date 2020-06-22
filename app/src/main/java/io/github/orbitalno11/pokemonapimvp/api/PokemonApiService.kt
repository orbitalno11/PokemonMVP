package io.github.orbitalno11.pokemonapimvp.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.orbitalno11.pokemonapimvp.util.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PokemonApiService {
    @GET("pokemon?limit=100")
    fun getPokemonList(): Call<HashMap<String, Any>>
}

object PokemonApi {
    val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }
}