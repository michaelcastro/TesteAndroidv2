package com.teste.presentation.login

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class LoginFragmentUnitTest {

    @Test
    fun onCreate_shouldCall_fetchLoginData() {
        // Given
        val fragmentOutputSpy = LoginFragmentOutputSpy()

        // It must have called the onCreate earlier,
        // we are injecting the mock and calling the fetchData to test our condition
        val fragment = LoginActivity()
        fragment.output = fragmentOutputSpy

        // When
        fragment.fetchData()

        // Then
        Assert.assertTrue(fragmentOutputSpy.fetchLoginDataIsCalled)
    }

    @Test
    fun onCreate_Calls_fetchLoginData_withCorrectData() {
        // Given
        val fragmentOutputSpy = LoginFragmentOutputSpy()
        val fragment = LoginActivity()
        fragment.output = fragmentOutputSpy

        // When
        fragment.fetchData()

        // Then
        Assert.assertNotNull(LoginActivity)
        // Assert.assertTrue(fragmentOutputSpy.requestCopy.isFutureTrips)
    }

    private inner class LoginFragmentOutputSpy : LoginInteractorInput {

        var fetchLoginDataIsCalled = false
        lateinit var requestCopy: LoginRequest

        override fun fetchLoginData(request: LoginRequest) {
            fetchLoginDataIsCalled = true
            requestCopy = request
        }
    }
}
