package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuizBinding
import com.rsschool.quiz.mock.Mock

abstract class BaseFragment : Fragment() {

    protected var navigationClickListener: Navigation? = null

    private var binding: FragmentQuizBinding? = null

    protected var radioId = -1

    protected var selectedText = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationClickListener = context as? Navigation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contextThemeWrapper: Context = ContextThemeWrapper(activity, provideThemeColor())

        val localInflater = inflater.cloneInContext(contextThemeWrapper)

        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), provideStatusBarColor())

        binding = FragmentQuizBinding.inflate(localInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            Toast.makeText(requireContext(), savedInstanceState.getInt(provideRestoreBundleKey(), -1), Toast.LENGTH_SHORT).show()
        }

        arguments?.let {
            val id = it.getInt(provideRestoreBundleKey(), -1)
            if (id != -1) {
                radioId = id
            }
        }

        if (this !is FirstFragment) {
            binding?.appBarLayout?.findViewById<Toolbar>(R.id.toolbar)?.run {
                setNavigationOnClickListener { navigationClickListener?.pop(radioId) }
                title = getString(R.string.title, provideMockIndex() + 1)
            }
        } else {
            binding?.appBarLayout?.findViewById<Toolbar>(R.id.toolbar)?.run {
                navigationIcon = null
                title = getString(R.string.title, provideMockIndex() + 1)
            }
        }

        binding?.question?.text = Mock.questions[provideMockIndex()].question

        binding?.optionOne?.text = Mock.questions[provideMockIndex()].answerOne
        binding?.optionTwo?.text = Mock.questions[provideMockIndex()].answerTwo
        binding?.optionThree?.text = Mock.questions[provideMockIndex()].answerThree
        binding?.optionFour?.text = Mock.questions[provideMockIndex()].answerFour
        binding?.optionFive?.text = Mock.questions[provideMockIndex()].answerFive

        binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            radioId = checkedId
            binding?.nextButton?.isEnabled = true
            selectedText = binding?.root?.findViewById<RadioButton>(checkedId)?.text.toString()
        }

        if (radioId != -1) {
            binding?.radioGroup?.check(radioId)
        }

        binding?.previousButton?.run {
            isEnabled = this@BaseFragment !is FirstFragment

            setOnClickListener {
                navigationClickListener?.pop(radioId)
            }
        }

        binding?.nextButton?.run {
            if (radioId == -1) {
                binding?.nextButton?.isEnabled = false
            }

            setOnClickListener {
                provideNext()
            }
        }

        if (this is FiveFragment) {
            binding?.nextButton?.text = getString(R.string.submit)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(provideRestoreBundleKey(), radioId)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)


        savedInstanceState?.let { bundle ->
            radioId = bundle.getInt(provideRestoreBundleKey(), -1)
        }

    }

    abstract fun provideMockIndex(): Int

    abstract fun provideRestoreBundleKey(): String

    abstract fun provideThemeColor(): Int

    abstract fun provideStatusBarColor(): Int


    abstract fun provideNext()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onDetach() {
        super.onDetach()
        navigationClickListener = null
    }
}