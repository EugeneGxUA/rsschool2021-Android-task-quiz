package com.rsschool.quiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R

class FourthFragment : BaseFragment() {

    companion object {
        fun getInstance(args : Bundle, selected : Int) : Fragment {
            return FourthFragment().apply {
                arguments = args
                arguments?.putInt(FOUR_FRAGMENT, selected)
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