package com.teste.presentation.home

import java.lang.ref.WeakReference

object HomeConfigurator {

    fun configureActivity(activity: HomeActivity) {

        val router = HomeRouter()
        router.fragment = WeakReference(activity)

        val presenter = HomePresenter()
        presenter.output = WeakReference(activity)

        val interactor = HomeInteractor()
        interactor.output = presenter

        activity.output = interactor
        activity.router = router
    }
}
