package com.youssif.youssifcodebase.models

import com.youssif.youssifcodebase.repository.db.article.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)