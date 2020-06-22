package io.github.orbitalno11.pokemonapimvp.template.activity

import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpInterface

class CustomActivityInterface {

    interface View: BaseMvpInterface.View{}
    interface Presenter: BaseMvpInterface.Presenter<View>{}

}