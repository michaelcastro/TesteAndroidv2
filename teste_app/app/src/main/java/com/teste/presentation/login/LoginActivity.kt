package com.teste.presentation.login

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.teste.R
import com.teste.domain.login.model.UserAccount
import kotlinx.android.synthetic.main.activity_login.*

interface LoginActivityInput {
    fun doLogin()
    fun displayLoginData(userAccount: UserAccount)
    fun showLoginMessage(message : String)
    fun setUpUser(user : String)
}

class LoginActivity : AppCompatActivity(), LoginActivityInput {

    lateinit var output: LoginInteractorInput
    lateinit var router: LoginRouter
    private var dialogProgress: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        LoginConfigurator.configureActivity(this)
        output.getUser()
    }

    fun doLogin(view : View){
        doLogin()
    }

    override fun doLogin() {
        showDialogLoading(resources.getString(R.string.login))
        output.doLogin(login.text.toString(), password.text.toString())
    }

    override fun displayLoginData(userAccount: UserAccount) {
        closeDialogLoading()
        router.openHomeActivity()
    }

    override fun showLoginMessage(message : String) {
        closeDialogLoading()
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton(android.R.string.yes) { _, _ ->
            }
            .show()
    }

    override fun setUpUser(user: String) {
        login.setText(user)
    }

    fun showDialogLoading(message: String) {
        dialogProgress = ProgressDialog.show(this, "", message, true)
        dialogProgress?.setCancelable(false)
        dialogProgress?.isShowing
    }

    fun closeDialogLoading() {
        dialogProgress?.dismiss()
    }

}
