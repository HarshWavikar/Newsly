package com.harshcode.newsly.data.remote.dto

import com.harshcode.newsly.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)