package com.csci448.jaidynnfohr.alpha_release.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.IScreenSpec
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

class NoSadNavHost{
    @Composable
    fun NoSadNavHost(
        viewModel : INoSadViewModel,
        navController: NavController
    ) {
        NavHost(
            navController = navController as NavHostController,
            startDestination = IScreenSpec.startDestination,
            builder = {
                IScreenSpec.allScreens.forEach { (route, screen) ->
                    if(screen != null) {
                        composable(
                            route = screen.route,
                            arguments = screen.arguments
                        ) {
                            backStackEntry ->
                                screen.Content(viewModel = viewModel,
                                navController = navController,
                                navBackStackEntry = backStackEntry)
                        }
                    }
                }
            }
        )
    }
}
