package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.ui.screens.settings.HelpSupportScreen
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

object HelpSupportScreenSpec : IScreenSpec {
    override val route: String = "help"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        HelpSupportScreen (onBack = {navController.popBackStack()})
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}