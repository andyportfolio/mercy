package com.sideproject.mercy.domain.usecase

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.domain.entity.OnBoarding
import com.sideproject.mercy.domain.gateway.OnBoardingGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnBoardingCase @Inject constructor(
    private val gateway: OnBoardingGateway
){
    suspend fun invoke() : Flow<Resource<OnBoarding>> {
        val response = gateway.getFirstPageData()

        //add some domain logic or call another usecase
        return response
    }
}