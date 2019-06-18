package com.teste.presentation.home

interface HomeInteractorInput {
    fun fetchHomeData(request: HomeRequest)
}

class HomeInteractor : HomeInteractorInput {

    var output: HomePresenterInput? = null
    var workerInput: HomeWorkerInput? = null
        get() {
            return field ?: HomeWorker()
        }

    override fun fetchHomeData(request: HomeRequest) {
        // Log.d(TAG, "In method fetchHomeData")
        val response = HomeResponse()

        // Call the workers
        // workerInput.someWork()

        // Call the presenter
        output?.presentHomeData(response)
    }

    companion object {
        const val TAG = "HomeInteractor"
    }
}
