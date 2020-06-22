package io.github.orbitalno11.pokemonapimvp.adapter.base

import androidx.recyclerview.widget.RecyclerView
import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvpPresenterNotCreateException

abstract class BaseListAdapterView<VH : BaseViewHolder, P : BaseMvpListAdapterInterface.Presenter<*>> :
    RecyclerView.Adapter<VH>(), BaseMvpListAdapterInterface.Adapter {

    private var p: P? = null

    init {
        p = createPresenter()
        p?.setAdapter(this)
    }

    abstract fun createPresenter(): P

    override fun getPresenter(): P {
        if (p != null) return p!!
        throw MvpPresenterNotCreateException()
    }

    fun getItems(): List<BaseItem>{
        return getPresenter().getItems()
    }

    fun getItem(pos: Int): BaseItem{
        return getPresenter().getItem(pos)
    }

    fun hasItem(): Boolean{
        return getPresenter().hasItems()
    }

    fun setItems(items: List<BaseItem>){
        getPresenter().setItems(items)
    }

    fun addItem(item: BaseItem){
        getPresenter().addItem(item)
    }

    fun removeItem(index: Int){
        getPresenter().removeItem(index)
    }

    fun removeAllItems(){
        getPresenter().removeAllItems()
    }
}