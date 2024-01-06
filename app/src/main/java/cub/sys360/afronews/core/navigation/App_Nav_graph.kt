package cub.sys360.afronews.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cub.sys360.afronews.presentation.HomeScreen

@Composable
fun navigationGraph( navController: NavHostController){
    
    
    NavHost(navController = navController, startDestination = navigationRoutes.homeScreen.routes){
        composable(route=navigationRoutes.homeScreen.routes){
            HomeScreen(navController)
        }
    }
    
}