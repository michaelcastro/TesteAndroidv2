package com.teste.domain.login.usercase

import com.teste.BuildConfig
import com.teste.data.source.remote.ApiRequest
import com.teste.domain.login.model.DataResponseLogin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRequest(val user: String, val password: String) {

    private var request: ApiRequest

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        request = retrofit.create(ApiRequest::class.java)
    }

    fun doLogin(): DataResponseLogin? {
        val call = request.doLogin(user, password)
        return call.execute().body()
    }

    private fun checkPassword(password: String): Boolean {
        return true
    }
}
