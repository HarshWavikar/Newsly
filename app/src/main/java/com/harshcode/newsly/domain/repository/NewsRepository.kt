package com.harshcode.newsly.domain.repository

import androidx.paging.PagingData
import com.harshcode.newsly.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}