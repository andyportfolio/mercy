/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.domain.usecase

import com.vclip.mercy.common.Resource
import com.vclip.mercy.domain.entity.SampleData
import com.vclip.mercy.domain.gateway.SampleGateway
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