package com.teste.presentation.home

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface HomeInteractorInput {
    fun fetchHomeData(request: HomeRequest)
}

class HomeInteractor : HomeInteractorInput {

    var output: HomePresenterInput? = null
    var workerInput: HomeWorkerInput? = null
        get() {
            return field ?: HomeWorker()
        }

    @SuppressLint("CheckResult")
    override fun fetchHomeData(request: HomeRequest) {
        val response = HomeResponse()
        Observable.fromCallable {
            workerInput?.getAllRecents(request.idUser)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("recents1", it.toString())
                response.recents = it
                output?.presentHomeData(response)
            },
                {
                  //  Log.e("recents2", it.message)
                    response.recents = null
                    it!!.message?.let { it1 ->
                        response.message = it.message!!
                        output?.presentHomeData(response)
                    }
                }
            )
    }

    companion object {
        const val TAG = "HomeInteractor"
    }
}
