package com.teste.presentation.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.teste.R
import com.teste.domain.model.UserAccount
import kotlinx.android.synthetic.main.activity_home.*

interface HomeActivityInput {
    fun displayHomeData(viewModel: HomeViewModel)
    fun showMessage(viewModel: HomeViewModel)
}

class HomeActivity : AppCompatActivity(), HomeActivityInput {

    lateinit var output: HomeInteractorInput
    lateinit var router: HomeRouter
    val userAccount: UserAccount by lazy { intent.getParcelableExtra<UserAccount>("USER_ACCOUNT") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        HomeConfigurator.configureActivity(this)
        fetchData()
    }

    fun fetchData() {
        user_name.text = userAccount.name
        account_number.text = userAccount.bankAccount
        balance.text = userAccount.balanceFormatted

        val request = HomeRequest()
        request.idUser = userAccount.userId
        output.fetchHomeData(request)
    }

    override fun displayHomeData(viewModel: HomeViewModel) {

        ll_loading.visibility = View.GONE

        val adapter = RecentesAdapter(viewModel.recents!!.statementList)
        recycler_statements.setHasFixedSize(true)
        recycler_statements.setAdapter(adapter)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_statements.setLayoutManager(mLayoutManager)
    }

    override fun showMessage(viewModel: HomeViewModel) {
        Toast.makeText(this, viewModel.message, Toast.LENGTH_LONG).show()
    }

    fun exit(view: View){
        finish()
    }

    companion object {
        const val TAG = "HomeActivity"
    }
}
