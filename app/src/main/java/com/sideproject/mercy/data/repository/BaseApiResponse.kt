package com.sideproject.mercy.data.repository

import com.sideproject.mercy.common.Resource
import retrofit2.Response

abstract class BaseApiResponse {
    suspend fun <T,U> safeApiCall(
        apiCall: suspend () -> Response<T>,
        mapper: (T) -> U
    ): Resource<U> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Resource.Success(mapper(body))
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): Resource<T> {
        return Resource.Error("Api call failed $errorMessage")
    }
}