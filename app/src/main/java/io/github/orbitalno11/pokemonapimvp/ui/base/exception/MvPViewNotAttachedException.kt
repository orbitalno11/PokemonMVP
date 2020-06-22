package io.github.orbitalno11.pokemonapimvp.ui.base.exception

import java.lang.RuntimeException

class MvPViewNotAttachedException: RuntimeException("Please call Presenter.attachView(MvpBaseView) before requesting data to the View") {
}