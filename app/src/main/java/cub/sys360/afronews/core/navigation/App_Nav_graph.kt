package cub.sys360.afronews.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_CATEGORY
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_CHANNEL_LOGO
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_DESC
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_IMG_URL
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_STATION
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_TIMESTAMP
import cub.sys360.afronews.core.appconstant.Appconstants.DETAIL_SCREEN_TITLE
import cub.sys360.afronews.presentation.HomeScreen
import cub.sys360.afronews.presentation.NewsDetailScreen
import cub.sys360.afronews.presentation.SeemoreScreen

@Composable
fun navigationGraph( navController: NavHostController){
    
    
    NavHost(navController = navController, startDestination = navigationRoutes.homeScreen.routes){

      //Home Screen Routes
        composable(
            route=navigationRoutes.homeScreen.routes,

        ){
            HomeScreen(navController)
        }



            //Detail Screen Routes
        composable(route=navigationRoutes.detailsScreen.routes,
            arguments = listOf(
                navArgument(name = "$DETAIL_SCREEN_TITLE"){
                    type= NavType.StringType
                },

                navArgument(name ="$DETAIL_SCREEN_STATION"){
                    type= NavType.StringType
                },


                navArgument(name = "$DETAIL_SCREEN_DESC"){
                    type= NavType.StringType
                },

                navArgument(name ="$DETAIL_SCREEN_IMG_URL"){
                    type= NavType.IntType
                },


                navArgument(name = "$DETAIL_SCREEN_CATEGORY"){
                    type= NavType.StringType
                },

                navArgument(name ="$DETAIL_SCREEN_CHANNEL_LOGO"){
                    type= NavType.IntType
                },


                navArgument(name ="$DETAIL_SCREEN_TIMESTAMP"){
                    type= NavType.StringType
                },






            )




            ){
            var title = it.arguments?.getString(DETAIL_SCREEN_TITLE)
            var station = it.arguments?.getString(DETAIL_SCREEN_STATION)
            var desc = it.arguments?.getString(DETAIL_SCREEN_DESC)
            var imgurl = it.arguments?.getInt(DETAIL_SCREEN_IMG_URL)
            var category = it.arguments?.getString("$DETAIL_SCREEN_CATEGORY")
            var channelLogo = it.arguments?.getString(DETAIL_SCREEN_CHANNEL_LOGO)
            var timestamp = it.arguments?.getString(DETAIL_SCREEN_TIMESTAMP)


           NewsDetailScreen(navController,title,station,desc,imgurl,category,channelLogo,timestamp)

        }



        //See more Screen

        composable(route = navigationRoutes.seeMoreScreen.routes){
             SeemoreScreen(navController)
        }



    }




    
}



