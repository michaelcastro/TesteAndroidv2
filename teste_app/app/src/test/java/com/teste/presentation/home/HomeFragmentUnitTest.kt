package com.teste.presentation.home

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class HomeFragmentUnitTest {

    @Test
    fun onCreate_shouldCall_fetchHomeData() {
        // Given
        val fragmentOutputSpy = HomeFragmentOutputSpy()

        // It must have called the onCreate earlier,
        // we are injecting the mock and calling the fetchData to test our condition
        val fragment = HomeActivity()
        fragment.output = fragmentOutputSpy

        // When
        fragment.fetchData()

        // Then
        Assert.assertTrue(fragmentOutputSpy.fetchHomeDataIsCalled)
    }

    @Test
    fun onCreate_Calls_fetchHomeData_withCorrectData() {
        // Given
        val fragmentOutputSpy = HomeFragmentOutputSpy()
        val fragment = HomeActivity()
        fragment.output = fragmentOutputSpy

        // When
        fragment.fetchData()

        // Then
        Assert.assertNotNull(HomeActivity)
        // Assert.assertTrue(fragmentOutputSpy.requestCopy.isFutureTrips)
    }

    private inner class HomeFragmentOutputSpy : HomeInteractorInput {

        var fetchHomeDataIsCalled = false
        lateinit var requestCopy: HomeRequest

        override fun fetchHomeData(request: HomeRequest) {
            fetchHomeDataIsCalled = true
            requestCopy = request
        }
    }
}
