package com.example.mygwf

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    companion object{
        const val BASE_URL = "https://test-api.gwf.ch/"
        const val LOGIN_URL = "auth/token/"
        const val ALL_METERS_URL = "reports/measurements/"
    }

    //@FormUrlEncoded
    @POST(LOGIN_URL)
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    @GET(ALL_METERS_URL)
    fun getAllMeters(@Header("Authorization") token: String): Call<List<Meter>>

    @GET(ALL_METERS_URL)
    fun searchMeterById(
            @Query("query") query: String
    ): Call<Meter>
}