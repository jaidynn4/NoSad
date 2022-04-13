package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.Profile
import com.csci448.jaidynnfohr.alpha_release.ui.screens.settings.AccountScreen
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

object AccountScreenSpec : IScreenSpec {
    override val route: String = "account"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: ViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        AccountScreen(viewModel = viewModel as NoSadViewModel,
            myProfile = Profile(
                language = stringResource(id = R.string.viewModel_placeholder),
                email = stringResource(id = R.string.viewModel_placeholder),
                name = stringResource(id = R.string.viewModel_placeholder),
                emergencyContact = stringResource(id = R.string.viewModel_placeholder),
                password = stringResource(id = R.string.viewModel_placeholder)),
            onBack = { navController.popBackStack() })
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}