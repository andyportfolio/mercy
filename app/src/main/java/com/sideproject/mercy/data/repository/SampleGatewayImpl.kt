/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.sideproject.mercy.data.repository

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.data.EndPoint.SAMPLE_URL
import com.sideproject.mercy.data.local.SampleDao
import com.sideproject.mercy.data.mapper.toSampleData
import com.sideproject.mercy.data.remote.dto.SampleDTO
import com.sideproject.mercy.domain.entity.SampleData
import com.sideproject.mercy.domain.gateway.SampleGateway
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleGatewayImpl @Inject constructor(
    private val httpClient: HttpClient, private val dao: SampleDao
) : BaseApiResponse(), SampleGateway {

    override suspend fun getSampleData(): Flow<Resource<SampleData>> {
        return flow {
            emit(safeApiCall(
                httpClient = httpClient,
                endPoint = SAMPLE_URL,
                mapper = { sampleDTO: SampleDTO -> sampleDTO.toSampleData() }
            ))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSampleDataFromRoom(id: Int): SampleData? {
        return dao.getMercyEntityById(id)?.toSampleData()
    }
}