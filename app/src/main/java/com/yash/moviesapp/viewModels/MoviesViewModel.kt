package com.yash.moviesapp.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash.moviesapp.Models.MoviesItem
import com.yash.moviesapp.Models.MoviesResponse
import com.yash.moviesapp.Repository.MoviesRepository
import com.yash.moviesapp.Utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository) : ViewModel() {

    private val _response = MutableLiveData<List<MoviesItem>>()
    val moviesResponse: MutableLiveData<List<MoviesItem>>
        get() = _response

    fun getMoviesList(){
        viewModelScope.launch {
            val response = repository.getMoviesList()
            if (response.isSuccessful && response.body() !=null){
                _response.postValue(response.body()!!.results)
            }
            else{
                val error = JSONObject(response.errorBody()!!.charStream().readText())
                Log.e(Constants.TAG,error.toString())
                Log.d(Constants.TAG,"Error : ${response.errorBody().toString()}    ${response.code()}")
            }
        }
    }


}