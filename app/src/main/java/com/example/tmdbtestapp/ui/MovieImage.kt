package com.example.tmdbtestapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.tmdbtestapp.R

@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        loading = {
            Box(contentAlignment = Alignment.Center){
                LoadingItem()
            }
        },
        error = {
            Image(
                painterResource(id = R.drawable.ic_photo),
                contentDescription = stringResource(id = R.string.cd_error_image),
                contentScale = ContentScale.Crop
            )
        },
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}