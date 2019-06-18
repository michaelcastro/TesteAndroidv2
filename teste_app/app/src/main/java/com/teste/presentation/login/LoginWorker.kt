package com.teste.presentation.login

import android.util.Log
import com.teste.BuildConfig
import com.teste.data.source.remote.ApiRequest
import com.teste.domain.login.model.DataResponseLogin
import com.teste.utils.Prefs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface LoginWorkerInput {
    fun doLogin( user: String, password: String): DataResponseLogin?
    fun saveUser( user: String)
    fun getUser(): String
}

class LoginWorker : LoginWorkerInput {

    private var request: ApiRequest

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        request = retrofit.create(ApiRequest::class.java)
    }

    override fun doLogin( user: String, password: String): DataResponseLogin? {
        val call = request.doLogin(user, password)
        val body = call.execute().body()
        Log.e("response1", body.toString())
        return body
    }

    override fun saveUser( user: String){
        Prefs.saveUser(user)
    }

    override fun getUser() = Prefs.getUser()

}
