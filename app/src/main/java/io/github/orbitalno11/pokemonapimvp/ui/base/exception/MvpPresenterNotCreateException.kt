package io.github.orbitalno11.pokemonapimvp.ui.base.exception

import java.lang.RuntimeException

class MvpPresenterNotCreateException: RuntimeException( "Please call createPresenter() before requesting data to the Presenter" ) {
}