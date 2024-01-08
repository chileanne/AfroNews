package cub.sys360.afronews.core.navigation


import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_CATEGORY
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_CHANNEL_LOGO
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_DESC
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_IMG_URL
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_STATION
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_TIMESTAMP
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_TITLE
import java.sql.Timestamp

sealed class navigationRoutes(val routes: String){

    object homeScreen: navigationRoutes(routes = "HomeScreen")

    object  detailsScreen: navigationRoutes(routes = "$DETAIL_SCREEN/{$DETAIL_SCREEN_TITLE}/{$DETAIL_SCREEN_STATION}/" +
            "{$DETAIL_SCREEN_DESC}/{$DETAIL_SCREEN_IMG_URL}/{$DETAIL_SCREEN_CATEGORY}/{$DETAIL_SCREEN_CHANNEL_LOGO}/{$DETAIL_SCREEN_TIMESTAMP}"){
        fun passRequiredArguments(
            title: String,
            station: String,
            desc: String,
            imgUrl: Int,
            category: String,
            channelLogo: Int,
            timestamp: String) :String {


            return "$DETAIL_SCREEN/$title/$station/$desc/$imgUrl/$category/$channelLogo/$timestamp"

        }
    }

    object  seeMoreScreen: navigationRoutes(routes = "SeeMoreScreen")



}
