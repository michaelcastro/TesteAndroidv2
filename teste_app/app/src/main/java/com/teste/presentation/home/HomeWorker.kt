package com.teste.presentation.home

import android.util.Log
import com.teste.BuildConfig
import com.teste.data.source.remote.ApiRequest
import com.teste.domain.model.Recents
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface HomeWorkerInput {
    fun getAllRecents(idUser: Int) : Recents?
}

class HomeWorker : HomeWorkerInput {
    private var request: ApiRequest

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        request = retrofit.create(ApiRequest::class.java)
    }

    override fun getAllRecents(idUser : Int): Recents? {
        val call = request.getRecents(idUser)
        val body = call.execute().body()
        Log.e("response1", body.toString())
        return body
    }


}
