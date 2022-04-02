package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.JournalPage
import com.csci448.jaidynnfohr.alpha_release.ui.screens.ScrollingCards
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

object JournalScreenSpec : IScreenSpec {

    override val route = "journal"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: INoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        NoSad_Scaffold(
            content = {
                JournalPage()
              },
            onAddItem = {navController.navigate(ColorWheelScreenSpec.navigateTo())},
            onJournal = {navController.navigate(navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
            bottomBarItemNumber = 3
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}