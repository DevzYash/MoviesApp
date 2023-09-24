package com.yash.moviesapp.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yash.moviesapp.Models.MoviesItem
import com.yash.moviesapp.Utils.Constants
import com.yash.moviesapp.databinding.MovieItemBinding


class MoviesAdapter : ListAdapter<MoviesItem, MoviesAdapter.MoviesViewHolder>(DiffUtils()) {
    inner class MoviesViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieItem: MoviesItem) {
//            binding.imageThumbnail.load(Constants.ORIGINAL_FORMAT+movieItem.backdrop_path)
//            binding.textTitle.text = movieItem.original_title
//            binding.textReleaseDate.text = movieItem.release_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
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