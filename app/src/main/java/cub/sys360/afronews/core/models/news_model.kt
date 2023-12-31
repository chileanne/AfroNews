package cub.sys360.afronews.core.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NewsModel(
    val title: String,
    val station: String ,
    val imageUrl : Int ,
    val desc: String,
    val category: String,
    val channelLogo : Int,
    val timestamp : String

    )
