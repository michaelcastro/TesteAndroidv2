package com.teste.presentation.home

import com.teste.domain.model.Recents
import java.lang.ref.WeakReference
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

interface HomePresenterInput {
    fun presentHomeData(response: HomeResponse)
}

class HomePresenter : HomePresenterInput {

    var output: WeakReference<HomeActivityInput>? = null

    override fun presentHomeData(response: HomeResponse) {

        val homeViewModel = HomeViewModel()

        if (response.recents != null) {
            homeViewModel.recents = Recents()

            for (statement in response.recents!!.statementList) {

                statement.date = formatDate(statement.date)
                statement.valeuFormatted = formatValue(statement.value)

                homeViewModel.recents!!.statementList.add(statement)

            }

            output?.get()?.displayHomeData(homeViewModel)
        } else {
            homeViewModel.message = response.message
            output?.get()?.showMessage(homeViewModel)
        }

    }

    fun formatDate(date: String): String {
        val initDate = SimpleDateFormat("yyyy-mm-dd").parse(date)
        val formatter = SimpleDateFormat("dd/mm/yyyy")
        return formatter.format(initDate)
    }

    fun formatValue(valeu: Float): String {
        val ptBr = Locale("pt", "BR")
        val valorString = NumberFormat.getCurrencyInstance(ptBr).format(valeu)
        return valorString
    }

    companion object {
        const val TAG = "HomePresenter"
    }
}
