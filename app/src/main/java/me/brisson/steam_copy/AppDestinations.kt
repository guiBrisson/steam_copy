package me.brisson.steam_copy

import androidx.navigation.NavHostController
import me.brisson.steam_copy.AppDestinations.HOME_ROUTE
import me.brisson.steam_copy.AppScreens.HOME_SCREEN
import me.brisson.steam_copy.AppScreens.LOGIN_SCREEN


private object AppScreens {
    const val LOGIN_SCREEN = "login"
    const val HOME_SCREEN = "home"
}

object AppDestinations {
    const val LOGIN_ROUTE = LOGIN_SCREEN
    const val HOME_ROUTE = HOME_SCREEN
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(route = HOME_ROUTE) {
            launchSingleTop = true
            restoreState = true
        }
    }

}