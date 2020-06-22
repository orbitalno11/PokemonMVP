package io.github.orbitalno11.pokemonapimvp.adapter.base

import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvPViewNotAttachedException
import java.lang.ref.WeakReference

abstract class BaseListAdapterPresenter<AD : BaseMvpListAdapterInterface.Adapter> :
    BaseMvpListAdapterInterface.Presenter<AD> {

    private var adapter: WeakReference<AD>? = null
    private var items: MutableList<BaseItem> = mutableListOf()

    override fun setAdapter(adapter: BaseMvpListAdapterInterface.Adapter) {
        @Suppress("UNCHECKED_CAST")
        this.adapter = WeakReference(adapter as AD)
    }

    override fun getAdapter(): AD {
        if (adapter != null) return adapter!!.get()!!
        throw MvPViewNotAttachedException()
    }

    override fun getItemViewType(pos: Int): Int {
        return items[pos].type
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItems(): List<BaseItem> {
        return items
    }

    override fun getItem(pos: Int): BaseItem {
        return items[pos]
    }

    override fun hasItems(): Boolean {
        return getItemCount() > 0
    }

    override fun setItems(items: List<BaseItem>) {
        this.items = items as MutableList
        getAdapter().notifyDataSetChange()
    }

    override fun addItem(item: BaseItem?) {
        item?.let {
            this.items.add(item)
            getAdapter().notifyItemInserted(getItemCount() - 1)
        }
    }

    override fun removeItem(index: Int) {
        this.items.removeAt(index)
        getAdapter().notifyItemRemoved(index)
    }

    override fun removeAllItems() {
        this.items.clear()
        getAdapter().notifyDataSetChange()
    }
}