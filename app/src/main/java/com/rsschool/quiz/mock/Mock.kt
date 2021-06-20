package com.rsschool.quiz.mock

object Mock {

    class Question(
        val question: String,
        val answerOne: String,
        val answerTwo: String,
        val answerThree: String,
        val answerFour: String,
        val answerFive: String,
        val rightAnswer : String
    )

    val questions: List<Question> = listOf(
        Question(
            "To be or not...",
            "Bye",
            "Don't know",
            "to be",
            "problem",
            "five",
            rightAnswer = "to be"
        ),
        Question(
            "Biggest animal",
            "Wale",
            "Elephant",
            "Tiger",
            "Human",
            "Dolphin",
            rightAnswer = "Wale"
        ),
        Question(
            "How many questions in this quiz",
            "one",
            "two",
            "three",
            "four",
            "five",
            rightAnswer = "five"
        ),
        Question(
            "What was the first color you see in this app",
            "blue",
            "yellow",
            "brown",
            "purple",
            "orange",
            rightAnswer = "orange"
        ),
        Question(
            "Do you like RS_School",
            "No",
            "Yes",
            "Wrong question",
            "Hm...",
            "I don't know",
            rightAnswer = "Yes"
        )
    )
}