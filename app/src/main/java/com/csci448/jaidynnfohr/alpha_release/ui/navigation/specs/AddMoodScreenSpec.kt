package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.EmotionsDropDown
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth

object AddMoodScreenSpec : IScreenSpec {

    override val route = "wheel"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        auth: FirebaseAuth
    ) {
        NoSad_Scaffold(
            content = {
                EmotionsDropDown(
                    onSaveMood = { colorId, string ->
                        viewModel.tempColorIdStorage = colorId
                        viewModel.tempStringStorage = string
                        navController.navigate(JournalScreenSpec.navigateTo())
                    }
                )
            },
            onAddMood = {navController.navigate(navigateTo())},
            onJournal = {navController.navigate(JournalScreenSpec.navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {navController.navigate(SettingsScreenSpec.navigateTo())},
            bottomBarItemNumber = 1
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}