package com.teste.utils

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.teste.ApplicationMain

object Prefs {
    enum class PREF_ID {
        user
    }

    fun saveUser(user: String) {
        Hawk.init(ApplicationMain.instance?.applicationContext).build()
        Hawk.put(PREF_ID.user.toString(), user);
    }

    fun getUser(): String? {
        Hawk.init(ApplicationMain.instance?.applicationContext).build()
        return Hawk.get(PREF_ID.user.toString());
    }

}