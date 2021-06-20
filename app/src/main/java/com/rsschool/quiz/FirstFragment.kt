package com.rsschool.quiz


import android.os.Bundle
import androidx.fragment.app.Fragment

class FirstFragment : BaseFragment() {

    companion object {
        fun getInstance() : Fragment {
            return FirstFragment()
        }

        const val FIRST_FRAGMENT_KEY = "firstFragment"
    }

    override fun provideMockIndex(): Int = 0

    override fun provideRestoreBundleKey(): String = FIRST_FRAGMENT_KEY

    override fun provideThemeColor(): Int = R.style.Theme_Quiz_First


    override fun provideStatusBarColor(): Int = R.color.deep_orange_100_dark

    override fun provideNext() {
        navigationClickListener?.navigateToSecond(Bundle(10).apply {
           putString(FIRST_FRAGMENT_KEY, selectedText)
        })
    }
}