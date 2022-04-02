package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.ui.LoginScreen
import com.csci448.jaidynnfohr.alpha_release.ui.screens.EmotionsDropDown
import com.csci448.jaidynnfohr.alpha_release.ui.screens.PastRecordScreen
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.util.RecordGenerator
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

object PastRecordsScreenSpec : IScreenSpec {

    override val route = "records"
    override val arguments: List<NamedNavArgument> = mutableListOf()

    @Composable
    override fun Content(
        viewModel: INoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        val list = mutableListOf<PastRecord>()
        for(i in 1..20){
            list.add(RecordGenerator.generateRandomRecord())
        }
        NoSad_Scaffold(
            content = {PastRecordScreen(list = list, onSelectRecord = {})},
            onAddItem = {navController.navigate(ColorWheelScreenSpec.navigateTo())},
            onJournal = {navController.navigate(JournalScreenSpec.navigateTo())},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
            bottomBarItemNumber = 2
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