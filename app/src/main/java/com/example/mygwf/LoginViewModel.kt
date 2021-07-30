package com.example.mygwf

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginViewModel constructor(private val repository: Repository): ViewModel() {

    private val _loginResponse : MutableLiveData<LoginResponse> = MutableLiveData()
    val loginResponse: LiveData<LoginResponse> get() = _loginResponse
    private val _issueResponse : MutableLiveData<String> = MutableLiveData()
    val issueResponse: LiveData<String> get() = _issueResponse

    fun login(username: String, password: String){
        val response = repository.login(username, password)
        response.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _issueResponse.postValue("Network Error")

            }

            override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
            ) {
                val loginResponse = response.body()
                if (response.isSuccessful && loginResponse != null){
                    _loginResponse.postValue(loginResponse)

                }else{
                    _issueResponse.postValue("Error identifying user!")

                }
            }
        })

    }

    fun saveToken(token: String){
        repository.saveToken(token)
    }
}