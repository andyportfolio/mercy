/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.sideproject.mercy.domain.gateway

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.domain.entity.SampleData
import kotlinx.coroutines.flow.Flow

//Note : define function what we need
interface SampleGateway {
    suspend fun getSampleData(): Flow<Resource<SampleData>>
    suspend fun getSampleDataFromRoom(id: Int): SampleData?
}