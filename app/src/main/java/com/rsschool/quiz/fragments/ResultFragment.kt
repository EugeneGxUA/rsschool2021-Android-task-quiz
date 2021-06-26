package com.rsschool.quiz.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.MainActivity
import com.rsschool.quiz.Navigation
import com.rsschool.quiz.R
import com.rsschool.quiz.databinding.FragmentResultBinding
import com.rsschool.quiz.mock.Mock

class ResultFragment : Fragment() {

    companion object {
        fun getInstance(args: Bundle): Fragment {
            return ResultFragment().apply {
                arguments = args
            }
        }
    }

    private var navigate : Navigation? = null

    private var binding: FragmentResultBinding? = null

    private var firstFragmentAnswer = ""
    private var secondFragmentAnswer = ""
    private var thirdFragmentAnswer = ""
    private var fourthFragmentAnswer = ""
    private var fifthFragmentAnswer = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigate = context as? Navigation
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.tvResult?.text = getString(R.string.result, checkAnswers())

        binding?.ivShare?.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"

                val message: String = assembleMessage()
                putExtra(Intent.EXTRA_TEXT, message)
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.quiz_result_title))
            }
            startActivity(Intent.createChooser(intent, "Quiz results"))
        }

        binding?.ivStart?.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }

        binding?.ivClose?.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun checkAnswers(): Int {
        return if (arguments != null) {
            arguments?.let { args ->
                firstFragmentAnswer = args.getString(FirstFragment.FIRST_FRAGMENT_KEY, "")
                secondFragmentAnswer = args.getString(SecondFragment.SECOND_FRAGMENT_KEY, "")
                thirdFragmentAnswer = args.getString(ThirdFragment.THIRD_FRAGMENT, "")
                fourthFragmentAnswer = args.getString(FourthFragment.FOUR_FRAGMENT, "")
                fifthFragmentAnswer = args.getString(FiveFragment.FIVE_FRAGMENT, "")
            }

            var score = 0
            if (firstFragmentAnswer == Mock.questions[0].rightAnswer) {
                score += 20
            }
            if (secondFragmentAnswer == Mock.questions[1].rightAnswer) {
                score += 20
            }
            if (thirdFragmentAnswer == Mock.questions[2].rightAnswer) {
                score += 20
            }
            if (fourthFragmentAnswer == Mock.questions[3].rightAnswer) {
                score += 20
            }
            if (fifthFragmentAnswer == Mock.questions[4].rightAnswer) {
                score += 20
            }

            score

        } else 0
    }

    private fun assembleMessage() : String {
        return """${getString(R.string.result, checkAnswers())}
            
             1)${Mock.questions[0].question}
             Your answer: $firstFragmentAnswer
             
             2)${Mock.questions[1].question}
             Your answer: $secondFragmentAnswer
             
             3)${Mock.questions[2].question}
             Your answer: $thirdFragmentAnswer
             
             4)${Mock.questions[3].question}
             Your answer: $fourthFragmentAnswer
             
             5)${Mock.questions[4].question}
             Your answer: $fifthFragmentAnswer
        """
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onDetach() {
        super.onDetach()
        navigate = null
    }
}