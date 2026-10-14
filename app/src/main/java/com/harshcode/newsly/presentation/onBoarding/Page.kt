package com.harshcode.newsly.presentation.onBoarding

import androidx.annotation.DrawableRes
import com.harshcode.newsly.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Latest News",
        description = "Stay updated with the latest news from around the world. Get breaking news and important updates delivered right to your fingertips.",
        image = R.drawable.latest_news
    ),
    Page(
        title = "Your Favorite News",
        description = "Save the stories you love and revisit them anytime. Keep all your favorite articles in one place for easy access..",
        image = R.drawable.save_news
    ),
    Page(
        title = "News That Matters to You",
        description = "Explore news across your favorite categories, from technology to sports. Personalize your feed and discover stories that match your interests.",
        image = R.drawable.your_category
    )
)