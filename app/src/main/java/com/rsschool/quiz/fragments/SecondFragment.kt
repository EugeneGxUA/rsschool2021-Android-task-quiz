package com.rsschool.quiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R

class SecondFragment : BaseFragment() {

    companion object {
        fun getInstance(args : Bundle, selected : Int) : Fragment {
            return SecondFragment().apply {
                arguments = args
                arguments?.putInt(SECOND_FRAGMENT_KEY, selected)
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