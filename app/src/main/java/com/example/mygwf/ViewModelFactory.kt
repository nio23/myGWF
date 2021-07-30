package com.example.mygwf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(
    private val repository: Repository

    ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            LoginViewModel(this.repository) as T
        }else if(modelClass.isAssignableFrom(MetersViewModel::class.java)) {
            MetersViewModel(this.repository) as T
        }
        else
        {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}