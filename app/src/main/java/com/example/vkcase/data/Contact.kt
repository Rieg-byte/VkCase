package com.example.vkcase.data

import androidx.annotation.DrawableRes
import com.example.vkcase.R

data class Contact(
    val name: String,
    @DrawableRes val image: Int
)

val listOfContact: List<Contact> = listOf(
    Contact(
        name = "Очень длинный контакт Тест для тестирования",
        image = R.drawable.user1
    ),
    Contact(
        name = "Владимир",
        image = R.drawable.user2
    ),
    Contact(
        name = "Дмитрий",
        image = R.drawable.user3
    ),
    Contact(
        name = "Антон",
        image = R.drawable.user4
    )


)