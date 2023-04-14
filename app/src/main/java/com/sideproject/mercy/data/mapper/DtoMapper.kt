package com.sideproject.mercy.data.mapper

import com.sideproject.mercy.data.local.MercyEntity
import com.sideproject.mercy.data.remote.dto.DogDTO
import com.sideproject.mercy.domain.entity.OnBoarding

fun DogDTO.toOnBoarding(): OnBoarding {
    return OnBoarding(
        id = id, title = status, imageUrl = message
    )
}
fun MercyEntity.toOnBoarding(): OnBoarding {
    return OnBoarding(
        id = id, title = title, imageUrl = imageUrl
    )
}