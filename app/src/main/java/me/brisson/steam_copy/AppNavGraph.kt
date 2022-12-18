package me.brisson.steam_copy

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.brisson.steam_copy.presentation.auth.LoginScreen
import me.brisson.steam_copy.presentation.shop.ShopScreen

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.LOGIN_ROUTE,
    navActions: AppNavigationActions = remember(navController) {
        AppNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestinations.LOGIN_ROUTE) {
            LoginScreen(
                onAuthenticated = { navActions.navigateToHome() }
            )
        }

        composable(route = AppDestinations.HOME_ROUTE) {
            ShopScreen()
        }
    }

}