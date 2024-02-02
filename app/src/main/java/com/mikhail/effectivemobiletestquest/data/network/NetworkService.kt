package com.mikhail.effectivemobiletestquest.data.network

import com.mikhail.effectivemobiletestquest.data.network.models.Product
import retrofit2.http.GET

interface NetworkService {

    @GET("v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getProducts(): Product
}