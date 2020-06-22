//package io.github.orbitalno11.pokemonapimvp.template.activity
//
//import android.os.Bundle
//import io.github.orbitalno11.pokemonapimvp.ui.base.BaseMvpActivity
//
//class CustomActivity: BaseMvpActivity<CustomActivityInterface.Presenter>(), CustomActivityInterface.View {
//    override fun createPresenter(): CustomActivityInterface.Presenter {
//        return CustomActivityPresenter.create()
//    }
//
//    override fun getLayoutView(): Int {
//        return 0
//    }
//
//    override fun bindView() {
//    }
//
//    override fun setupInstance() {
//    }
//
//    override fun setupView() {
//    }
//
//    override fun initial() {
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//    }
//
//}