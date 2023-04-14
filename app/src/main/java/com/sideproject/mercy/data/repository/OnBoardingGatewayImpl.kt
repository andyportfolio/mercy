package com.sideproject.mercy.data.repository

import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.data.local.MercyDao
import com.sideproject.mercy.data.mapper.toOnBoarding
import com.sideproject.mercy.data.remote.api.MercyAPI
import com.sideproject.mercy.domain.entity.OnBoarding
import com.sideproject.mercy.domain.gateway.OnBoardingGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OnBoardingGatewayImpl @Inject constructor(
    private val api: MercyAPI, private val dao: MercyDao
) : BaseApiResponse(), OnBoardingGateway {

    override suspend fun getFirstPageData(): Flow<Resource<OnBoarding>> {
        return flow<Resource<OnBoarding>> {
            emit(safeApiCall(
              apiCall =   { api.getDog() },
              mapper =   { DogDTO -> DogDTO.toOnBoarding() }))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getFirstPageDataFromRoom(id: Int): OnBoarding? {
        return dao.getMercyEntityById(id)?.toOnBoarding()
    }
}