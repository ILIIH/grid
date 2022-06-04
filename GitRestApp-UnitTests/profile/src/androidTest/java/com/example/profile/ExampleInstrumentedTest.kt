package com.example.profile

import android.Manifest
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.GrantPermissionRule
import com.example.profile.profile.ProfileActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @Rule
    var grantPermissionRule = GrantPermissionRule.grant(Manifest.permission.INTERNET)
    @Test
    fun testVisability() {

        val activityScenario = ActivityScenario.launch(ProfileActivity::class.java)

        onView(withId(R.id.Avatar)).check(matches(isDisplayed()))
        onView(withId(R.id.linearLayout)).check(matches(isDisplayed()))
        onView(withId(R.id.Memor)).check(matches(isDisplayed()))
        onView(withId(R.id.MemoryUsage)).check(matches(isDisplayed()))
        onView(withId(R.id.NickName)).check(matches(isDisplayed()))
    }
}
