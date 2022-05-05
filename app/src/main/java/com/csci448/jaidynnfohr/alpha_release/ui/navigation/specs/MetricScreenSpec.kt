package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.ui.*
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel

object MetricScreenSpec : IScreenSpec {

    override val route = "metrics"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        NoSad_Scaffold(
            content = {
                if(viewModel.colorIdList.isEmpty()) {
                    for(i in 1..30) {
                        viewModel.colorIdList.add(R.color.metrics_dark_grey_color)
                    }
                }
                DayWeekMonth(viewModel.colorIdList, viewModel.moodList) },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(JournalScreenSpec.navigateTo())},
            onMetrics = {navController.navigate(navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {navController.navigate(SettingsScreenSpec.navigateTo())},
            bottomBarItemNumber = 4
        )
    }


//
//    @Composable
//    override fun Content(viewModel: ISamodelkinCharacterViewModel,
//                         navController: NavController,
//                         navBackStackEntry: NavBackStackEntry
//    ) {
//        val characterList = viewModel.characterListLiveData.observeAsState()
//        CharacterListScreen(characterList = characterList.value, onSelectCharacter = {
//                character -> navController.navigate(
//            DetailScreenSpec.navigateTo(character.id.toString())
//        )
//        }
//        )
//    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }
}
