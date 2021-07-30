package com.example.mygwf

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class Repository constructor(
    private val apiClient: ApiClient,
    private val session: SessionManager
    ) {

    fun login(username: String, password: String) = apiClient.getApiService().login(LoginRequest(username,password))

    fun saveToken(token: String){
        session.saveAuthToken(token)
    }

    fun fetchToken()= session.fetchAuthToken()

    fun getAllMeters(token: String?) = apiClient.getApiService().getAllMeters("Bearer $token")

    fun getSearchResults(query: String) = apiClient.getApiService().searchMeterById(query)

}