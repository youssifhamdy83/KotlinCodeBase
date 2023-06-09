package com.youssif.youssifcodebase.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.youssif.youssifcodebase.R
import com.youssif.youssifcodebase.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Youssif Hamdy on 11/2/2022.
 */
@AndroidEntryPoint
class ArticleNewsFragment : Fragment(R.layout.fragment_article) {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}