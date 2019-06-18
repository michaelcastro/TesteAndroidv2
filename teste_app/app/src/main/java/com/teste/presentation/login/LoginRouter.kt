package com.teste.presentation.login

import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.support.v4.app.Fragment
import com.teste.presentation.home.HomeActivity

import java.lang.ref.WeakReference

interface LoginRouterInput {
    fun openHomeActivity()
    fun passDataToNextScene(position: Int, nextFragment: Fragment)
}

class LoginRouter : LoginRouterInput, AdapterView.OnItemClickListener {

    var activity: WeakReference<LoginActivity>? = null

    override fun openHomeActivity() {
        activity?.get()?.startActivity(Intent(activity?.get(),HomeActivity::class.java))
    }

    override fun passDataToNextScene(position: Int, nextFragment: Fragment) {
        // Based on the position or some other data decide the data for the next scene

        // val args =  Bundle()
        // args.putParcelable("flight",flight)
        // nextFragment.arguments = args
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // Log.d(TAG, "onItemClick() called with: parent = [$parent], "
        // + "view = [$view], position = [$position], id = [$id]")
      //  val nextFragment = determineNextScreen(position)
    //    passDataToNextScene(position, nextFragment)
        // Ask the activity to show the next activity. eg ..
        // activity?.get()?.homeFragmentListener?.startPastTripFragment(nextFragment)

    }

    companion object {
        const val TAG = "HomeRouter"
    }
}
