package io.github.orbitalno11.pokemonapimvp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvpNotSetLayoutException
import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvpPresenterNotCreateException

abstract class BaseMvpActivity<P: BaseMvpInterface.Presenter<*>> :
    AppCompatActivity(), BaseMvpInterface.View {
    private var p: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = createPresenter()
        p?.attachView(this)
        val layoutResId = getLayoutView()
        if (getLayoutView() == 0) throw MvpNotSetLayoutException()
        setContentView(layoutResId)
        bindView()
        setupInstance()
        setupView()
        getPresenter().onViewCreate()
        if (savedInstanceState == null){
            initial()
        }
    }

    override fun onStart() {
        super.onStart()
        getPresenter().onViewStart()
    }

    override fun onStop() {
        super.onStop()
        getPresenter().onViewStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().onViewDestroy()
    }

    override fun getPresenter(): P {
        if (p != null) return p as P
        throw MvpPresenterNotCreateException()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreView(savedInstanceState)
    }

    abstract fun createPresenter(): P
    abstract fun getLayoutView(): Int
    abstract fun bindView()
    abstract fun setupInstance()
    abstract fun setupView()
    abstract fun initial()
    fun restoreView(savedInstanceState: Bundle?) {}
}