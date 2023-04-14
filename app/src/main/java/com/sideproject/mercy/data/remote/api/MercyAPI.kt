package com.sideproject.mercy.data.remote.api

import com.sideproject.mercy.data.Config
import com.sideproject.mercy.data.remote.dto.DogDTO
import retrofit2.Response
import retrofit2.http.*

/**
 * Mercy 서버와 통신 할 API 리스트
 */
interface MercyAPI {
    @GET(Config.RANDOM_URL)
    suspend fun getDog(): Response<DogDTO>
}