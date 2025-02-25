package com.rsschool.quiz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R

class FiveFragment : BaseFragment() {

    companion object {
        fun getInstance(args: Bundle, selected : Int): Fragment {
            return FiveFragment().apply {
                arguments = args
                arguments?.putInt(FIVE_FRAGMENT, selected)
            }
        }

        const val FIVE_FRAGMENT = "FiveFrag"
    }

    override fun provideMockIndex(): Int = 4

    override fun provideRestoreBundleKey(): String = FIVE_FRAGMENT

    override fun provideThemeColor(): Int = R.style.Theme_Quiz_Five

    override fun provideStatusBarColor(): Int = R.color.light_green_100_dark

    override fun provideNext() {
        arguments?.let {
            it.putString(FIVE_FRAGMENT, selectedText)
            navigationClickListener?.finishScreen(it)
        }
    }
}