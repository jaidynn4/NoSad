package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.CreateAccountScreen
import com.csci448.jaidynnfohr.alpha_release.ui.LoginScreen
import com.csci448.jaidynnfohr.alpha_release.ui.NewUserScreen
import com.csci448.jaidynnfohr.alpha_release.ui.screens.EmotionsDropDown
import com.csci448.jaidynnfohr.alpha_release.ui.screens.ScrollingCards
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

object ColorWheelScreenSpec : IScreenSpec {

    override val route = "wheel"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: INoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        NoSad_Scaffold(
            content = { EmotionsDropDown() },
            onAddItem = {navController.navigate(ColorWheelScreenSpec.navigateTo())},
            onJournal = {},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {navController.navigate(SettingsScreenSpec.navigateTo())},
            bottomBarItemNumber = 1
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