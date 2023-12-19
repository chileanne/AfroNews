package cub.sys360.afronews.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cub.sys360.afronews.R
import cub.sys360.afronews.core.models.NewsModel

class homeViewModel : ViewModel() {

    //var carousleData by mutableStateOf<List<NewsModel>>(emptyList())

    var carousleData = mutableListOf<NewsModel>();

    init {

       carousleData.add(NewsModel(
           station = "CNN",
           desc = "Mbappe Stellar performance Takes football to new heights",
           imageUrl = R.drawable.mbappe,
           category = "Sport",
           channelLogo = R.drawable.cnn,


       ))

        carousleData.add(NewsModel(
            station = "Channels Tv",
            desc = "Isreal-Gaza war still rages an urgent call for peace is needed",
            imageUrl =R.drawable.isreal,
            category = "World News",
            channelLogo = R.drawable.channels

        ))


        carousleData.add(NewsModel(
            station = "BBC",
            desc = "Putin visit UAE and Saudi Arabia on a rare one day visit",
            imageUrl = R.drawable.putin,
            category = "World News",
            channelLogo = R.drawable.bbc

        ))


        carousleData.add(NewsModel(
            station = "AIT",
            desc = "Ukraine tells washignton not to stop aid package",
            imageUrl = R.drawable.ukraine,
            category = "War in Ukraine",
            channelLogo = R.drawable.ait

        ))

    }
}