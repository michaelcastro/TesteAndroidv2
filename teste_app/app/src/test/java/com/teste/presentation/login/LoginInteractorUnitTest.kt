package com.teste.presentation.login

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LoginInteractorUnitTest {

    @Test
    fun passwordTest() {
        val interactor = LoginInteractor()
        val password = "Test@1"
        val p = interactor.checkPassword(password)
        Assert.assertTrue(p)
    }

}
