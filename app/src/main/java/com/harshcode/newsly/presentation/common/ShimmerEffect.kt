package com.harshcode.newsly.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.harshcode.newsly.R
import com.harshcode.newsly.presentation.Dimens.ArticleCardHeight
import com.harshcode.newsly.presentation.Dimens.ArticleCardSize
import com.harshcode.newsly.presentation.Dimens.ArticleCardWidth
import com.harshcode.newsly.presentation.Dimens.ExtraSmallPadding
import com.harshcode.newsly.presentation.Dimens.ExtraSmallPadding2
import com.harshcode.newsly.presentation.Dimens.IconShimmerSize
import com.harshcode.newsly.presentation.Dimens.MediumPadding1
import com.harshcode.newsly.presentation.Dimens.TextShimmerHeight

fun Modifier.shimmerEffect() = composed {
   val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmerEffect(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(ArticleCardHeight)
                .width(ArticleCardWidth)
                .clip(shape = MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Column(
            modifier = Modifier
                .padding(ExtraSmallPadding)
                .height(ArticleCardSize),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect()
            )
            Row(
                modifier = Modifier.padding(horizontal = MediumPadding1),
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.2f)
                        .height(TextShimmerHeight)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Box(
                    modifier = Modifier
                        .size(IconShimmerSize)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(TextShimmerHeight)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .shimmerEffect()
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun ArticleCardShimmerEffectPreview() {
    ArticleCardShimmerEffect()
}