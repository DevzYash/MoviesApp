package com.yash.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.moviesapp.adapter.MoviesAdapter
import com.yash.moviesapp.databinding.FragmentMainBinding
import com.yash.moviesapp.viewModels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private val viewModel by viewModels<MoviesViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        moviesAdapter = MoviesAdapter()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.moviesResponse.observe(viewLifecycleOwner) {
            moviesAdapter.submitList(it)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = moviesAdapter
        }
        viewModel.getMoviesList()




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}