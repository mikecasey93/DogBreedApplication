package com.example.dogbreedapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedapplication.data.api.RetroFitInstance
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getDogBreed()
    }

    private fun getDogBreed() {
        viewModelScope.launch {
            val result = RetroFitInstance.apiClient.getDogBreeds()
            if(result.message != null){
                _text.postValue(result.message.toString())
            }
        }
    }
}