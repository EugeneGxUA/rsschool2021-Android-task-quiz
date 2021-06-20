package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Navigation {

    private lateinit var binding : ActivityMainBinding

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
        transaction.replace(R.id.container, SecondFragment.getInstance(args))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toThirdFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ThirdFragment.getInstance(args))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toFourthFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FourthFragment.getInstance(args))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun toFiveFragment(args: Bundle) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FiveFragment.getInstance(args))
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
//        val transaction = supportFragmentManager.beginTransaction()
//
//        transaction.replace(R.id.container, FirstFragment.getInstance())
//        transaction.commit()
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

    override fun pop() {
        supportFragmentManager.popBackStack()
    }
}