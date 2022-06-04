package com.example.profile.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.profile.profile.profileFragment.ProfileViewModel

class ProfileFragmentFactory(private val viewModel: ProfileViewModel? = null) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return super.instantiate(classLoader, className)
    }
}