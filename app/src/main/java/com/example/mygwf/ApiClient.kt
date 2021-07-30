package com.example.mygwf

import com.example.mygwf.ApiService.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: ApiService

    fun getApiService(token: String?=null): ApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder()
                    /*.addInterceptor{ chain ->
                        chain.proceed(chain.request().newBuilder().also {
                            it.addHeader("Authorization",value = "Bearer $token")
                        }.build())
                    }*/
                    .also { client->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

        return apiService
    }

}