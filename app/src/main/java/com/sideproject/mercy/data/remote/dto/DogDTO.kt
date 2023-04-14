package com.sideproject.mercy.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.sideproject.mercy.domain.entity.OnBoarding

//https://dog.ceo/api/breeds/image/random

//{
//    "message": "https://images.dog.ceo/breeds/mexicanhairless/n02113978_147.jpg",
//    "status": "success"
//}

data class DogDTO(
    @SerializedName("id")
    val id: Int = 1,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)