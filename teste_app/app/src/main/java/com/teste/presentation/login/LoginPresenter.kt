package com.teste.presentation.login

import android.util.Log
import com.teste.domain.login.model.DataResponseLogin
import java.lang.ref.WeakReference

interface LoginPresenterInput {
    fun presentLoginData(response: DataResponseLogin)
    fun showMessage(message: String)
    fun setUpUser(user : String)
}

class LoginPresenter : LoginPresenterInput {

    var output: WeakReference<LoginActivityInput>? = null

    override fun presentLoginData(response: DataResponseLogin) {

         if (response.error.code.equals(0)){
           Log.e("Response", response.toString())
             output?.get()?.displayLoginData(response.userAccount)
         }else{
             output?.get()?.showLoginMessage(response.error.message)
         }
    }

    override fun showMessage(message: String){
        output?.get()?.showLoginMessage(message)
    }

    override fun setUpUser(user: String) {
        output?.get()?.setUpUser(user)
    }

    companion object {
        const val TAG = "LoginPresenter"
    }
}
