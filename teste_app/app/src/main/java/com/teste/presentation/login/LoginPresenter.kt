package com.teste.presentation.login

import android.util.Log
import com.teste.domain.model.DataResponseLogin
import java.lang.ref.WeakReference
import java.text.NumberFormat
import java.util.*

interface LoginPresenterInput {
    fun presentLoginData(response: LoginResponse)
    fun showMessage(message: String)
    fun setUpUser(user : String)
}

class LoginPresenter : LoginPresenterInput {

    var output: WeakReference<LoginActivityInput>? = null

    override fun presentLoginData(response: LoginResponse) {
        if (response.dataResponseLogin != null) {
            val loginViewModel = LoginViewModel()
            if (response.dataResponseLogin!!.error.code.equals(0)) {
                response.dataResponseLogin!!.userAccount.balanceFormatted = formatValue(response.dataResponseLogin!!.userAccount.balance)
                loginViewModel.dataResponseLogin = response.dataResponseLogin
                output?.get()?.displayLoginData(loginViewModel)
            } else {
                output?.get()?.showLoginMessage(response.dataResponseLogin!!.error.message)
            }
        }
    }

    override fun showMessage(message: String){
        output?.get()?.showLoginMessage(message)
    }

    override fun setUpUser(user: String) {
        output?.get()?.setUpUser(user)
    }

    fun formatValue(valeu : Float) : String{
        val ptBr = Locale("pt", "BR")
        val valorString = NumberFormat.getCurrencyInstance(ptBr).format(valeu)
        return valorString
    }

    companion object {
        const val TAG = "LoginPresenter"
    }
}
