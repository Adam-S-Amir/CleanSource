package com.example.cleansource.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.cleansource.NewsAdapter
import com.example.cleansource.NewsRepository
import com.example.cleansource.NewsViewModel
import com.example.cleansource.NewsViewModelFactory
import com.example.cleansource.R
import com.example.cleansource.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )

        val repository = NewsRepository()
        val viewModelFactory = NewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        newsAdapter = NewsAdapter()
        binding.recyclerView.adapter = newsAdapter

        viewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.submitList(articles)
        })

        viewModel.fetchTopHeadlines("5e9c3883-a7fa-4f6d-aa67-56dec392a9a9")

        return binding.root
    }
}
