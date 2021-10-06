package com.rsschool.quiz.model

import android.content.Context
import android.os.Parcelable
import com.rsschool.quiz.R
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Questions(
    val id: Int,
    val question: String,
    val option_1: String,
    val option_2: String,
    val option_3: String,
    val option_4: String,
    val option_5: String,
    val answer: Int
) : Parcelable {

    companion object {

        fun questionsList(context: Context): List<Questions> {
            return listOf(
                Questions(
                    1,
                    context.getString(R.string.question_1),
                    context.getString(R.string.answer_1_1),
                    context.getString(R.string.answer_1_2),
                    context.getString(R.string.answer_1_3),
                    context.getString(R.string.answer_1_4),
                    context.getString(R.string.answer_1_5),
                    4,
                ),
                Questions(
                    2,
                    context.getString(R.string.question_2),
                    context.getString(R.string.answer_2_1),
                    context.getString(R.string.answer_2_2),
                    context.getString(R.string.answer_2_3),
                    context.getString(R.string.answer_2_4),
                    context.getString(R.string.answer_2_5),
                    1,
                ),
                Questions(
                    3,
                    context.getString(R.string.question_3),
                    context.getString(R.string.answer_3_1),
                    context.getString(R.string.answer_3_2),
                    context.getString(R.string.answer_3_3),
                    context.getString(R.string.answer_3_4),
                    context.getString(R.string.answer_3_5),
                    4,
                ),
                Questions(
                    4,
                    context.getString(R.string.question_4),
                    context.getString(R.string.answer_4_1),
                    context.getString(R.string.answer_4_2),
                    context.getString(R.string.answer_4_3),
                    context.getString(R.string.answer_4_4),
                    context.getString(R.string.answer_4_5),
                    5,
                ),
                Questions(
                    5,
                    context.getString(R.string.question_5),
                    context.getString(R.string.answer_5_1),
                    context.getString(R.string.answer_5_2),
                    context.getString(R.string.answer_5_3),
                    context.getString(R.string.answer_5_4),
                    context.getString(R.string.answer_5_5),
                    5,
                )
            )
        }
    }
}