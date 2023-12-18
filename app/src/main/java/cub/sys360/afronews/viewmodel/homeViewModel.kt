package cub.sys360.afronews.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cub.sys360.afronews.core.models.NewsModel

class homeViewModel : ViewModel() {

    //var carousleData by mutableStateOf<List<NewsModel>>(emptyList())

    var carousleData = mutableListOf<NewsModel>();

    init {

       carousleData.add(NewsModel(
           station = "CNN",
           desc = "Mbappe Stellar performance Takes football to new heights",
           imageUrl = ""

       ))

        carousleData.add(NewsModel(
            station = "Channels Tv",
            desc = "Isreal-Gaza war still rages on",
            imageUrl = ""

        ))


        carousleData.add(NewsModel(
            station = "First Post",
            desc = "Putin visit UAE and Saudi Arabia on a rare one day visit",
            imageUrl = ""

        ))


        carousleData.add(NewsModel(
            station = "First Post",
            desc = "Ukraine tells washignton not to stop aid package",
            imageUrl = ""

        ))

    }
}