package io.github.orbitalno11.pokemonapimvp.template.activity

import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpPresenter

class CustomActivityPresenter: BaseMvpPresenter<CustomActivityInterface.View>(), CustomActivityInterface.Presenter {
    companion object{
        fun create(): CustomActivityInterface.Presenter{
            return CustomActivityPresenter()
        }
    }
}