package com.example.profile

import android.Manifest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.GrantPermissionRule
import com.example.profile.profile.ProfileActivity
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit4ClassRunner::class)
class ProfileInstrumentedTest {

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

object ViewModelUtil {
    fun <T : ViewModel> createFor(model: T): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    @Suppress("UNCHECKED_CAST")
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class $modelClass")
            }
        }
    }
}
