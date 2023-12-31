package com.yash.moviesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import coil.transition.CrossfadeTransition
import com.yash.moviesapp.Models.MoviesItem
import com.yash.moviesapp.R
import com.yash.moviesapp.Utils.Constants
import com.yash.moviesapp.databinding.MovieItemBinding
import dagger.hilt.internal.aggregatedroot.codegen._com_yash_moviesapp_MoviesApplication


class MoviesAdapter : ListAdapter<MoviesItem, MoviesAdapter.MoviesViewHolder>(DiffUtils()) {
    inner class MoviesViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItem: MoviesItem) {
            binding.itemPoster.load(Constants.ORIGINAL_FORMAT+movieItem.poster_path){
                crossfade(true)
            }
            binding.itemMovieTitle.text = movieItem.title
            if (movieItem.vote_average.toInt() ==0){
                binding.itemMovieVote.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
                binding.itemMovieVote.text = "0 Ratings"
            }else{
                binding.itemMovieVote.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vote_star,0,0,0)
                binding.itemMovieVote.text = " ${movieItem.vote_average}/10 IMDB"
            }

//            binding.textReleaseDate.text = movieItem.release_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movieItem = getItem(position)
        holder.bind(movieItem)
    }


    class DiffUtils : DiffUtil.ItemCallback<MoviesItem>() {
        override fun areItemsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviesItem, newItem: MoviesItem): Boolean {
            return oldItem == newItem
        }

    }
}