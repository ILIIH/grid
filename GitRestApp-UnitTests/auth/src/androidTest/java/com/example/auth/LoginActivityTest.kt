package com.example.auth

import android.Manifest
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

internal class LoginActivityTest

@RunWith(AndroidJUnit4ClassRunner::class)
class AuthInstrumentedTest {

    @get:Rule
    var grantPermissionRule = GrantPermissionRule.grant(Manifest.permission.INTERNET)

    @Test
    fun testKeyboardisOpened() {
        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.UserNameTextField)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.UserNameTextField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun LogintestVisability() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        Espresso.onView(ViewMatchers.withId(R.id.imageView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.AuthTokenTextField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.Enter_Button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.UserNameTextField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
