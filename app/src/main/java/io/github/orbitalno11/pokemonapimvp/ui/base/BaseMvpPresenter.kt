package io.github.orbitalno11.pokemonapimvp.ui.base

import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvPViewNotAttachedException
import java.lang.ref.WeakReference


abstract class BaseMvpPresenter<V: BaseMvpInterface.View>: BaseMvpInterface.Presenter<V> {
    private var mMvpView: WeakReference<V>? = null

    override fun attachView(mvpView: BaseMvpInterface.View) {
        @Suppress("UNCHECKED_CAST")
        mMvpView = WeakReference(mvpView as V)
    }

    override fun detachView() {
        mMvpView = null
    }

    override fun getView(): V {
        if (mMvpView != null) return mMvpView!!.get()!!
        throw MvPViewNotAttachedException()
    }

    override fun onViewCreate() {
    }

    override fun onViewStart() {
    }

    override fun onViewStop() {
    }

    override fun onViewDestroy() {
    }
}