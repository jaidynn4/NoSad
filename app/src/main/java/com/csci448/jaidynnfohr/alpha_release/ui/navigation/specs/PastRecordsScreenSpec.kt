package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.ui.screens.PastRecordScreen
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.util.RecordGenerator
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

object PastRecordsScreenSpec : IScreenSpec {

    override val route = "records"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        val list = mutableListOf<PastRecord>()
        for(i in 1..20){
            list.add(RecordGenerator.generateRandomRecord())
        }

        val journalEntryList = viewModel.journalEntriesListLiveData.observeAsState()
        NoSad_Scaffold(
            content = {
                PastRecordScreen(
                    //list = viewModel.recordsList,
                    list = journalEntryList.value,
                    onSelectRecord = {}
                )
            },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(JournalScreenSpec.navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {navController.navigate(SettingsScreenSpec.navigateTo())},
            bottomBarItemNumber = 3
        )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}