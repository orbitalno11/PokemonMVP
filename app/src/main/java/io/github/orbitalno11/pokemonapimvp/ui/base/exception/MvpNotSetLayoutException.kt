package io.github.orbitalno11.pokemonapimvp.ui.base.exception

import java.lang.RuntimeException

class MvpNotSetLayoutException : RuntimeException("getLayoutView() not return 0") {
}