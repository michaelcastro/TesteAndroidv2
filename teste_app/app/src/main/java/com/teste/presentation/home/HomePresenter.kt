package com.teste.presentation.home

import java.lang.ref.WeakReference

interface HomePresenterInput {
    fun presentHomeData(response: HomeResponse)
}

class HomePresenter : HomePresenterInput {

    var output: WeakReference<HomeActivityInput>? = null

    override fun presentHomeData(response: HomeResponse) {
        // Log.d(TAG, "presentHomeData() called with: response = [$response]");
        // Do your decoration or filtering here

    }

    companion object {
        const val TAG = "HomePresenter"
    }
}
