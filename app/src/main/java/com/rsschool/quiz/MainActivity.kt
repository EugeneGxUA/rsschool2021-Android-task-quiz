package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.rsschool.quiz.databinding.ActivityMainBinding
import com.rsschool.quiz.fragments.*

class MainActivity : AppCompatActivity(), Navigation {

    private lateinit var binding : ActivityMainBinding

    private var firstCheckedId = -1
    private var secCheckedId = -1
    private var thCheckedId = -1
    private var fourCheckedId = -1
    private var fiveCheckedId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toFirstFragment()
    }

    private fun toFirstFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FirstFragment.getInstance())
        transaction.commit()
    }

    private fun toSecondFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, SecondFragment.getInstance(args, secCheckedId))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toThirdFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ThirdFragment.getInstance(args, thCheckedId))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toFourthFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FourthFragment.getInstance(args, fourCheckedId))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toFiveFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FiveFragment.getInstance(args, fiveCheckedId))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toResultFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ResultFragment.getInstance(args))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun navigateToFirstInclusive() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun navigateOnFirst() {
        toFirstFragment()
    }

    override fun navigateToSecond(args : Bundle) {
        toSecondFragment(args)
    }

    override fun navigateToThird(args: Bundle) {
        toThirdFragment(args)
    }

    override fun navigateToFour(args: Bundle) {
        toFourthFragment(args)
    }

    override fun navigateToFive(args: Bundle) {
        toFiveFragment(args)
    }

    override fun finishScreen(args: Bundle) {
        toResultFragment(args)
    }

    override fun pop(id : Int) {
        when (supportFragmentManager.fragments.last()) {
            is SecondFragment -> secCheckedId = id
            is ThirdFragment -> thCheckedId = id
            is FourthFragment -> fourCheckedId = id
            is FiveFragment -> fiveCheckedId = id
        }

        supportFragmentManager.popBackStack()
    }
}