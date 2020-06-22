package io.github.orbitalno11.pokemonapimvp.adapter.base

interface BaseMvpListAdapterInterface {

    interface Adapter{
        fun getPresenter(): Presenter<*>
        fun notifyDataSetChange()
        fun notifyItemInserted(index: Int)
        fun notifyItemRemoved(index: Int)
    }

    interface Presenter<AD: Adapter>{
        fun setAdapter(adapter: Adapter)
        fun getAdapter(): AD
        fun getItemViewType(pos: Int): Int
        fun getItemCount(): Int
        fun hasItems(): Boolean
        fun getItems(): List<BaseItem>
        fun getItem(pos: Int): BaseItem
        fun setItems(items: List<BaseItem>)
        fun addItem(item: BaseItem?)
        fun removeItem(index: Int)
        fun removeAllItems()
    }
}