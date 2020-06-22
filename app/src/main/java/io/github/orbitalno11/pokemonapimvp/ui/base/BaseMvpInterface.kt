package io.github.orbitalno11.pokemonapimvp.ui.base

interface BaseMvpInterface {

    interface View {
        fun getPresenter(): Presenter<*>
    }

    interface Presenter<V: View> {
        fun attachView(mvpView: View)
        fun detachView()
        fun getView(): V
        fun onViewCreate()
        fun onViewDestroy()
        fun onViewStart()
        fun onViewStop()
    }
}