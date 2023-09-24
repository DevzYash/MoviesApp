package com.yash.moviesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yash.moviesapp.Utils.Constants
import com.yash.moviesapp.viewModels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MoviesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
//        viewModel.moviesResponse.observe(this, Observer {
//            it.listIterator().forEach {
//                Log.d(Constants.TAG,it.original_title +"\n")
//            }
//        })
//
//        viewModel.getMoviesList()

    }
}