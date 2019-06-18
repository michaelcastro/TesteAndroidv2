package com.teste.presentation.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teste.R

interface HomeActivityInput {
    fun displayHomeData(viewModel: HomeViewModel)
}

class HomeActivity : AppCompatActivity(), HomeActivityInput {

    lateinit var output: HomeInteractorInput
    lateinit var router: HomeRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        HomeConfigurator.configureActivity(this)
        fetchData()
    }

    fun fetchData() {
        // create Request and set the needed input
        val request = HomeRequest()

        // Call the output to fetch the data
        output.fetchHomeData(request)
    }

    override fun displayHomeData(viewModel: HomeViewModel) {
        // Log.d(TAG, "displayHomeData() called with: viewModel = [$viewModel]")
        // Deal with the data, update the states, ui etc..
    }

    companion object {
        const val TAG = "HomeActivity"
    }
}
