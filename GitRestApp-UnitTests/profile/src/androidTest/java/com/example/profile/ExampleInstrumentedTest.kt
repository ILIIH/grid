package com.example.profile

import android.Manifest
import androidx.paging.PagingData
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.example.core.domain.Repo
import com.example.gitapp.framework.GithubRepository
import com.example.profile.profile.ProfileActivity
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Flowable
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    val repo1 = Repo(1, "", "", "", "", 2, 2, "")
    val Dataset = PagingData.from(listOf(repo1, repo1, repo1, repo1, repo1))

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

    @get:Rule
    var activityRule = ActivityTestRule(ProfileActivity::class.java)

    @Test
    fun testCaseForRecyclerItemAdd() {
        val repoSoure = mockk<GithubRepository>()
        every {
            repoSoure.getRepository(any())
        } returns Flowable.just(Dataset)
    }
}
