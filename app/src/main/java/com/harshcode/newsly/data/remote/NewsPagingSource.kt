package com.harshcode.newsly.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.harshcode.newsly.domain.model.Article
import com.harshcode.newsly.util.Constants.API_KEY

class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
) : PagingSource<Int, Article>() {

    var totalNewsCount = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {  /* here we make a request to the api and return that articles */
        val page = params.key ?: 1

        return try {
            val newsResponse = newsApi.getNews(page = page, sources = sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                prevKey = null,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
       return state.anchorPosition?.let {anchorPosition ->
           val anchorPage = state.closestPageToPosition(anchorPosition = anchorPosition)
           anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

       }
    }
}