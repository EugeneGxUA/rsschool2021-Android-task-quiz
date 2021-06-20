package com.rsschool.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment

class FourthFragment : BaseFragment() {

    companion object {
        fun getInstance(args : Bundle) : Fragment {
            return FourthFragment().apply {
                arguments = args
            }
        }

        const val FOUR_FRAGMENT = "fourFragm"
    }

    override fun provideMockIndex(): Int = 3

    override fun provideRestoreBundleKey(): String = FOUR_FRAGMENT

    override fun provideThemeColor(): Int = R.style.Theme_Quiz_Four

    override fun provideStatusBarColor(): Int = R.color.deep_purple_100_dark

    override fun provideNext() {
        arguments?.let {
            it.putString(FOUR_FRAGMENT, selectedText)
            navigationClickListener?.navigateToFive(it)
        }
    }


}