package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.*
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
            content = { DayWeekMonth() },
            onAddMood = {navController.navigate(AddMoodScreenSpec.navigateTo())},
            onJournal = {navController.navigate(JournalScreenSpec.navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
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