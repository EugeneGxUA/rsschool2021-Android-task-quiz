package com.rsschool.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment

class SecondFragment : BaseFragment() {

    companion object {
        fun getInstance(args : Bundle) : Fragment {
            return SecondFragment().apply {
                arguments = args
            }
        }

        const val SECOND_FRAGMENT_KEY = "secFragKey"
    }

    override fun provideMockIndex(): Int = 1

    override fun provideRestoreBundleKey(): String = SECOND_FRAGMENT_KEY

    override fun provideThemeColor(): Int = R.style.Theme_Quiz_Second

    override fun provideStatusBarColor(): Int = R.color.yellow_100_dark


    override fun provideNext() {
        arguments?.let {
            it.putString(SECOND_FRAGMENT_KEY, selectedText)
            navigationClickListener?.navigateToThird(it)
        }
    }

}