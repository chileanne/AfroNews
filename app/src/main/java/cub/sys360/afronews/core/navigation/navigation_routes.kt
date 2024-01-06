package cub.sys360.afronews.core.navigation

sealed class navigationRoutes(val routes: String){

    object homeScreen: navigationRoutes(routes = "HomeScreen")

    object  detailsScreen: navigationRoutes(routes = "DetailScreen/")

    object  seeMoreScreen: navigationRoutes(routes = "SeeMoreScreen")

}
