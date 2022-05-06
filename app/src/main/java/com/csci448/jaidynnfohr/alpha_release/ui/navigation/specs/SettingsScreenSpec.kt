package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.csci448.jaidynnfohr.alpha_release.ui.screens.Settings
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth

object SettingsScreenSpec : IScreenSpec {
    override val route: String = "settings"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        auth: FirebaseAuth
    ) {

      Settings(
          onAccountClick = { navController.navigate(AccountScreenSpec.navigateTo()) },
          onNotificationsClick = { navController.navigate(NotificationsScreenSpec.navigateTo()) },
          onPrivacySecurityClick = { navController.navigate(PrivacySupportScreenSpec.navigateTo()) },
          onHelpSupportClick = { navController.navigate(HelpSupportScreenSpec.navigateTo()) },
          onAboutClick = { navController.navigate(AboutScreenSpec.navigateTo()) },
          onBack = { navController.popBackStack() },
          onLogout = {
              viewModel.signOut()
          },
          onLogoutSuccessfull = { navController.navigate(DetailScreenSpec.navigateTo()) },
          avm = viewModel
      )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}