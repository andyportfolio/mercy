package com.sideproject.mercy.domain.gateway

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.domain.entity.OnBoarding
import kotlinx.coroutines.flow.Flow

//TODO : how many gateway we need
interface OnBoardingGateway {
    suspend fun getFirstPageData(): Flow<Resource<OnBoarding>>
    suspend fun getFirstPageDataFromRoom(id: Int): OnBoarding?
}