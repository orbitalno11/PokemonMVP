package io.github.orbitalno11.pokemonapimvp.adapter.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(parent: ViewGroup, layout: Int) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false)) {

    init {
        bind(itemView)
    }

    abstract fun bind(view: View)
    protected fun getContext(): Context {
        return itemView.context
    }
}