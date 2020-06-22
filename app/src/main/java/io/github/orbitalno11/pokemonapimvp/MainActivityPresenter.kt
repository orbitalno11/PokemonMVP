package io.github.orbitalno11.pokemonapimvp

import android.util.Log
import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpPresenter

class MainActivityPresenter : BaseMvpPresenter<MainActivityInterface.View>(),
    MainActivityInterface.Presenter {

    companion object {
        fun create(): MainActivityInterface.Presenter {
            return MainActivityPresenter()
        }
    }

    override fun setupText(str: String) {
//        val str = "Hello World"
        getView().changeText(str)
    }


}