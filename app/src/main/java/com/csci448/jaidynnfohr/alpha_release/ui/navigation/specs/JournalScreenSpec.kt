package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.JournalPage
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import java.util.*
import com.google.firebase.auth.FirebaseAuth

object JournalScreenSpec : IScreenSpec {

    override val route = "journal"
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
                JournalPage(
                    mood_choice = if (viewModel.tempStringStorage != "") viewModel.tempStringStorage else stringResource(id = R.string.select_a_mood_label),
                    color_id_selection = viewModel.tempColorIdStorage,
                    title_text = if (viewModel.tempTitleStorage != "") viewModel.tempTitleStorage else "",
                    thoughts_text = if(viewModel.tempThoughtsStorage != "") viewModel.tempThoughtsStorage else "",
                    onAddMood = {title, thoughts ->
                        viewModel.tempColorIdStorage = R.color.white
                        viewModel.tempStringStorage = ""
                        viewModel.tempTitleStorage = title
                        viewModel.tempThoughtsStorage = thoughts
                        navController.navigate(AddMoodScreenSpec.navigateTo())
                    },
                    onSaveJournalEntry = {colorId, string, title, date, textTime, audioTime, textEntry, audio ->
                        viewModel.colorIdList.add(colorId)
                        viewModel.moodList.add(string)
//                        viewModel.recordsList.add(0,
//                            PastRecord(
//                                title = title,
//                                date = date,
//                                textTime = textTime,
//                                audioTime = audioTime,
//                                textEntry = textEntry,
//                                audio = audio,
//                                moodColor = colorId
//                            )
//                        )
                        //TODO get rid of all other past record calls
                        viewModel.addJournalEntry(
                            JournalEntry(
                                journal_title = title,
                                journal_entry = textEntry,
                                mood_selected = string,
                                journal_timestamp = Calendar.getInstance().time,
                                mood_color_id = colorId
                            )
                        )

                        //Reset the temp viewModel variables
                        navController.navigate(PastRecordsScreenSpec.navigateTo())
                        viewModel.tempColorIdStorage = R.color.white
                        viewModel.tempStringStorage = ""
                        viewModel.tempTitleStorage = ""
                        viewModel.tempThoughtsStorage = ""
                    }
                )
              },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {navController.navigate(SettingsScreenSpec.navigateTo())},
            bottomBarItemNumber = 2
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}