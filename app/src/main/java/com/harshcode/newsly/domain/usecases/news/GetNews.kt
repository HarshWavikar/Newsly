package com.harshcode.newsly.domain.usecases.news

import androidx.paging.PagingData
import com.harshcode.newsly.domain.model.Article
import com.harshcode.newsly.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources : List<String>): Flow<PagingData<Article>>{
       return newsRepository.getNews(sources = sources )
    }
}