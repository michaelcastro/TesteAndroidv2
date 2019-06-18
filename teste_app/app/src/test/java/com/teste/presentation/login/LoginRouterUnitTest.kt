package com.teste.presentation.login

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.ref.WeakReference

@RunWith(RobolectricTestRunner::class)
class LoginRouterUnitTest {

    @Test
    fun test_LoginRouter_determineNextScreen_when_Input_Is() {
        // Given
        // Setup Data

        val router = LoginRouter()
        val fragment = LoginActivity()
        fragment.router = router
        router.activity = WeakReference(fragment)

        // When
        // Based on the position or some other data decide what is the next scene

        val nextFragment = router.determineNextScreen(0)

        // Then

        val nextFragmentName = nextFragment.javaClass.name
        // Assert.assertEquals("When the some Data passed to LoginRouter" +
        //        " Then next Fragment should be ...",
        //        nextFragmentName,
        //        SomeFragment::class.java.name)
    }

    companion object {
        const val TAG = "LoginRouterUnitTest"
    }
}
