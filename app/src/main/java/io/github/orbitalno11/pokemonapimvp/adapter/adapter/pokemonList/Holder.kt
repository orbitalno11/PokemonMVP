package io.github.orbitalno11.pokemonapimvp.adapter.adapter.pokemonList

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.github.orbitalno11.pokemonapimvp.R
import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseViewHolder
import io.github.orbitalno11.pokemonapimvp.models.PokemonLess

class Holder(private val parent: ViewGroup): BaseViewHolder(parent, R.layout.list_pokemon) {
    private lateinit var name: TextView
    private lateinit var picture: ImageView
    private var listener: View.OnClickListener? = null

    override fun bind(view: View) {
        name = view.findViewById(R.id.pokemon_name)
        picture = view.findViewById(R.id.pokemon_picture)
    }

    fun onBind(item: PokemonLess){
        name.text = item.name
        itemView.setOnClickListener(listener)
    }

    fun setHolderClick(listener: View.OnClickListener){
        this.listener = listener
    }
}