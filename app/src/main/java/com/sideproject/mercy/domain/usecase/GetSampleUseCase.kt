/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.sideproject.mercy.domain.usecase

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.domain.entity.SampleData
import com.sideproject.mercy.domain.gateway.SampleGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSampleUseCase @Inject constructor(
    private val gateway: SampleGateway
){
    suspend fun invoke() : Flow<Resource<SampleData>> {
        val response = gateway.getSampleData()

        //add some domain logic or call another usecase
        return response
    }
}