package com.example.mygwf

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MetersViewModel constructor(private val repository: Repository): ViewModel() {

    private val _allMetersResponse : MutableLiveData<List<Meter>> = MutableLiveData()
    val allMetersResponse: LiveData<List<Meter>> get() = _allMetersResponse




    fun getAllMeters(){
        val response = repository.getAllMeters(repository.fetchToken())
        response.enqueue(object : Callback<List<Meter>>{
            override fun onResponse(call: Call<List<Meter>>, response: Response<List<Meter>>) {
                if (response.isSuccessful) {
                    _allMetersResponse.postValue(response.body())
                    Log.d("ListOfMeters", "SUCCEED")
                }

            }

            override fun onFailure(call: Call<List<Meter>>, t: Throwable) {
                Log.d("ListOfMeters", t.toString())
            }

        })


    }
}