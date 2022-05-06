package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.ui.screens.settings.AboutScreen
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth

object AboutScreenSpec : IScreenSpec {
    override val route: String = "about"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        auth: FirebaseAuth
    ) {
        AboutScreen(onBack = { navController.popBackStack() })
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}