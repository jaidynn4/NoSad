package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.ui.screens.settings.Account
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

object AccountScreenSpec : IScreenSpec {
    override val route: String = "account"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: INoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
//        Account(viewModel = viewModel, myProfile = ) {
//
//        }
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}