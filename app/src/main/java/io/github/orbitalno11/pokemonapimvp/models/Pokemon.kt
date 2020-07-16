package io.github.orbitalno11.pokemonapimvp.models

import io.github.orbitalno11.pokemonapimvp.adapter.base.BaseItem

data class Pokemon (
    var name: String = "",
    var id: String = "",
    var url: String = ""
): BaseItem()