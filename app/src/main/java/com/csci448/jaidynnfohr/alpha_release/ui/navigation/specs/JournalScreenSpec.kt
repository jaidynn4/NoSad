package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.JournalPage
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

object JournalScreenSpec : IScreenSpec {

    override val route = "journal"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        NoSad_Scaffold(
            content = {
                JournalPage(
                    mood_choice = if (viewModel.tempStringStorage != "") viewModel.tempStringStorage else stringResource(id = R.string.add_mood_label_long),
                    color_selection = if (viewModel.tempColorStorage != Color.Unspecified) viewModel.tempColorStorage else Color.White,
                    onAddMood = {
                        viewModel.tempColorStorage = Color.Unspecified
                        viewModel.tempStringStorage = ""
                        navController.navigate(AddMoodScreenSpec.navigateTo())
                    },
                    onSaveJournalEntry = { color, string ->
                        //todo save a record as well
                        viewModel.colorList.add(color)
                        viewModel.moodList.add(string)
                        navController.navigate(PastRecordsScreenSpec.navigateTo())
                    }
                )
              },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
            bottomBarItemNumber = 2
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}