package com.rsschool.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment

class ThirdFragment : BaseFragment() {

    companion object {
        fun getInstance(args : Bundle, selected : Int) : Fragment {
            return ThirdFragment().apply {
                arguments = args
                arguments?.putInt(THIRD_FRAGMENT, selected)
            }
        }

        const val THIRD_FRAGMENT = "thirdFragm"
    }

    override fun provideMockIndex(): Int = 2

    override fun provideRestoreBundleKey(): String = THIRD_FRAGMENT

    override fun provideThemeColor(): Int = R.style.Theme_Quiz_Third

    override fun provideStatusBarColor(): Int = R.color.cyan_100_dark


    override fun provideNext() {
        arguments?.let {
            it.putString(THIRD_FRAGMENT, selectedText)
            navigationClickListener?.navigateToFour(it)

        }
    }
}