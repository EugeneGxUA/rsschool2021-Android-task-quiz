package com.rsschool.quiz

import android.os.Bundle

interface Navigation {

    fun navigateToFirstInclusive()

    fun navigateOnFirst()

    fun navigateToSecond(args : Bundle)

    fun navigateToThird(args: Bundle)

    fun navigateToFour(args: Bundle)

    fun navigateToFive(args: Bundle)

    fun finishScreen(args: Bundle)

    fun pop()
}