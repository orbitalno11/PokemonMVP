package io.github.orbitalno11.pokemonapimvp

import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpInterface

class MainActivityInterface {

    interface View : BaseMvpInterface.View{
        fun changeText(str: String)
    }

    interface Presenter: BaseMvpInterface.Presenter<View>{
        fun setupText(str: String)
    }

}