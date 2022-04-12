package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

sealed interface IScreenSpec {

    val route: String
    val arguments: List<NamedNavArgument>

    companion object {
        val startDestination = DetailScreenSpec.route

        val allScreens = IScreenSpec::class.sealedSubclasses.associate {
            it.objectInstance?.route to it.objectInstance
        }
    }


    @Composable
    fun Content(
        viewModel: ViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry)

    fun navigateTo(vararg args: String?): String
}