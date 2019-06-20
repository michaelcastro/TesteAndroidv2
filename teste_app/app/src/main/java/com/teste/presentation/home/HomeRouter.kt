package com.teste.presentation.home

import android.widget.AdapterView
import android.support.v4.app.Fragment

import java.lang.ref.WeakReference

interface HomeRouterInput {
    fun detailStatement(position: Int)
}

class HomeRouter : HomeRouterInput {

    override fun detailStatement(position: Int) {
    }

    var activity: WeakReference<HomeActivity>? = null


    companion object {
        const val TAG = "HomeRouter"
    }
}
