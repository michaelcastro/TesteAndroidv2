package com.teste.data.source.remote

import com.teste.domain.model.Recents
import com.teste.domain.model.DataResponseLogin
import retrofit2.Call
import retrofit2.http.*

interface ApiRequest {

    @FormUrlEncoded
    @POST("login")
    fun doLogin(@Field("user") user: String, @Field("password") password: String) : Call<DataResponseLogin>

    @GET("statements/{idUser}")
    fun getRecents(@Path("idUser") idUser: Int) : Call<Recents>
}