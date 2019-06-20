package com.teste.presentation.login

import android.content.Intent
import com.teste.domain.model.UserAccount
import com.teste.presentation.home.HomeActivity

import java.lang.ref.WeakReference

interface LoginRouterInput {
    fun openHomeActivity(userAcccount : UserAccount)
}

class LoginRouter : LoginRouterInput {

    var activity: WeakReference<LoginActivity>? = null

    override fun openHomeActivity(userAcccount : UserAccount) {
        val intent = Intent(activity?.get(),HomeActivity::class.java)
        intent.putExtra("USER_ACCOUNT", userAcccount)
        activity?.get()?.startActivity(intent)
        activity?.get()?.finish()
    }

    companion object {
        const val TAG = "HomeRouter"
    }
}
