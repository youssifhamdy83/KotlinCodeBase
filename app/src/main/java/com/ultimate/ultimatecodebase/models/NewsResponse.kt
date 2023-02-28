package com.ultimate.ultimatecodebase.models

import com.ultimate.ultimatecodebase.repository.db.article.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)