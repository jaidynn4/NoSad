package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.ui.screens.Settings

object SettingsScreenSpec : IScreenSpec {
    override val route: String = "settings"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: ViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {

      Settings(
          onAccountClick = { navController.navigate(AccountScreenSpec.navigateTo()) },
          onNotificationsClick = { navController.navigate(NotificationsScreenSpec.navigateTo()) },
          onPrivacySecurityClick = { navController.navigate(PrivacySupportScreenSpec.navigateTo()) },
          onHelpSupportClick = { navController.navigate(HelpSupportScreenSpec.navigateTo()) },
          onAboutClick = { /*TODO*/},
          onBack = { navController.popBackStack() }
      )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}