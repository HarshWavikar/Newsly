package com.harshcode.newsly.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.harshcode.newsly.R
import com.harshcode.newsly.domain.model.Article
import com.harshcode.newsly.domain.model.Source
import com.harshcode.newsly.presentation.Dimens.ArticleCardHeight
import com.harshcode.newsly.presentation.Dimens.ArticleCardSize
import com.harshcode.newsly.presentation.Dimens.ArticleCardWidth
import com.harshcode.newsly.presentation.Dimens.ExtraSmallPadding
import com.harshcode.newsly.presentation.Dimens.ExtraSmallPadding2
import com.harshcode.newsly.presentation.Dimens.SmallIconSize
import com.harshcode.newsly.ui.theme.NewslyTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(
        modifier = modifier.clickable { onClick() }
    ) {
        AsyncImage(
            modifier = Modifier
                .height(ArticleCardHeight)
                .width(ArticleCardWidth)
                .clip(shape = MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = "News Image"
        )
        Column(
            modifier = Modifier
                .padding(ExtraSmallPadding)
                .height(ArticleCardSize),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
            }
            HorizontalDivider()
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardPreview() {
    NewslyTheme {
        Surface {
            ArticleCard(
                article = Article(
                    author = "",
                    content = "",
                    description = "",
                    publishedAt = "2 hours",
                    source = Source(id = "", name = "BBC"),
                    title = "Her train broke down. Her phone died. And then she met her Saver in a",
                    url = "",
                    urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
                ),
                onClick = {}
            )
        }
    }
}
