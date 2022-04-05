package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.JournalPage
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel
import com.csci448.jaidynnfohr.alpha_release.R

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
                JournalPage(
                    //TODO set equal to the state of AddMoodScreen choices when they are set
                    mood_choice = stringResource(id = R.string.add_mood_label_long),
                    color_selection = colorResource(id = R.color.app_green_color),
                    onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())}
                )
              },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
            bottomBarItemNumber = 4
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}