package com.teste.presentation.login

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


interface LoginInteractorInput {
    fun doLogin(request: LoginRequest)
    fun checkPassword(password: String): Boolean
    fun getUser()
}

class LoginInteractor : LoginInteractorInput {

    var output: LoginPresenterInput? = null
    var workerInput: LoginWorkerInput? = null
        get() {
            return field ?: LoginWorker()
        }

    @SuppressLint("CheckResult")
    override fun doLogin(request: LoginRequest) {
        if (checkPassword(request.password)) {
            val response = LoginResponse()
            Observable.fromCallable {
                workerInput?.saveUser(request.user)
                workerInput?.doLogin(request.user, request.password)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response.dataResponseLogin = it
                    output?.presentLoginData(response)
                },
                    { it!!.message?.let { it1 -> output?.showMessage(it1) } }
                )
        }
    }

    override fun checkPassword(password: String): Boolean {
        var number = false
        var maiuscula = false
        var minuscula = false
        var simbol = false
        for (c in password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                number = true
            } else if (c >= 'A' && c <= 'Z') {
                maiuscula = true
            } else if (c >= 'a' && c <= 'z') {
                minuscula = true;
            } else {
                simbol = true
            }
        }
        val result = number && maiuscula && simbol
        if (password.trim().equals("")) {
            output?.showMessage("Digite sua senha")
        } else if (!result) {
            output?.showMessage("Senha inválida")
        }
        return result
    }

    override fun getUser() {
        val user = workerInput?.getUser()
        user?.let { output?.setUpUser(it) }
    }

    companion object {
        const val TAG = "LoginInteractor"
    }
}
