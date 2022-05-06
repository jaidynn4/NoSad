package com.csci448.jaidynnfohr.alpha_release.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.IScreenSpec
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth

class NoSadNavHost{
    @Composable
    fun NoSadNavHost(
        viewModel: NoSadViewModel,
        navController: NavController,
        auth: FirebaseAuth
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
                                screen.Content(
                                    viewModel = viewModel,
                                    navController = navController,
                                    navBackStackEntry = backStackEntry,
                                    auth = auth
                                )
                        }
                    }
                }
            }
        )
    }
}
