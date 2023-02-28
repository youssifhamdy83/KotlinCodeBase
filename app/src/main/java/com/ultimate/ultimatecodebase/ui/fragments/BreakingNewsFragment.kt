package com.ultimate.ultimatecodebase.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ultimate.ultimatecodebase.R
import com.ultimate.ultimatecodebase.adapters.AdapterNews
import com.ultimate.ultimatecodebase.ui.NewsViewModel
import com.ultimate.ultimatecodebase.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_breaking_news.*


/**
 * Created by Youssif Hamdy on 11/2/2022.
 */
@AndroidEntryPoint
class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    private val viewModel: NewsViewModel by viewModels()
    lateinit var adapterNews: AdapterNews


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->

            when (response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        adapterNews.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {message ->
                        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
                        Log.e("error","An error occured : $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }


        })
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {

        adapterNews = AdapterNews()
        rvBreakingNews.apply {
            adapter = adapterNews
            layoutManager = LinearLayoutManager(activity)
        }

    }





}