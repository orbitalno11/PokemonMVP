package io.github.orbitalno11.pokemonapimvp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvpNotSetLayoutException
import io.github.orbitalno11.pokemonapimvp.ui.base.exception.MvpPresenterNotCreateException

abstract class BaseMvpFragment<P : BaseMvpInterface.Presenter<*>> : Fragment(),
    BaseMvpInterface.View {
    private var p: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = createPresenter()
        p?.attachView(this)
        savedInstanceState?.let {
            onRestoreInstanceState(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutId = getLayoutView()
        if (getLayoutView() == 0) throw MvpNotSetLayoutException()
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
        setupInstance()
        setupView()
        getPresenter().onViewCreate()
        if (savedInstanceState == null) {
            initial()
        } else {
            restoreView(savedInstanceState)
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

    abstract fun createPresenter(): P
    abstract fun getLayoutView(): Int
    abstract fun bindView(view: View)
    abstract fun setupInstance()
    abstract fun setupView()
    abstract fun initial()
    fun restoreView(savedInstanceState: Bundle?) {}
    fun onRestoreInstanceState(savedInstanceState: Bundle?) {}

}