package com.teste.data.source.remote

import com.teste.domain.login.model.DataResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiRequest {

    @FormUrlEncoded
    @POST("login")
    fun doLogin(@Field("user") user: String, @Field("password") password: String) : Call<DataResponseLogin>
}