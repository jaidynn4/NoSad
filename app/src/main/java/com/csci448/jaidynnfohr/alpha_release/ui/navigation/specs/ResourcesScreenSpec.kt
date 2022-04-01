package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.Resource
import com.csci448.jaidynnfohr.alpha_release.ui.LoginScreen
import com.csci448.jaidynnfohr.alpha_release.ui.screens.EmotionsDropDown
import com.csci448.jaidynnfohr.alpha_release.ui.screens.ResourceScreen
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold
import com.csci448.jaidynnfohr.alpha_release.viewmodels.INoSadViewModel

object ResourcesScreenSpec : IScreenSpec {

    override val route = "resources"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: INoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry
    ) {
        val list = mutableListOf<Resource>()
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_medical_title),
                blurb = stringResource(id = R.string.resources_medical_blurb)
            )
        )
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_best_practices_title),
                blurb = stringResource(id = R.string.resources_best_practices_blurb)
            )
        )
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_stats_title),
                blurb = stringResource(id = R.string.resources_stats_blurb)
            )
        )
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_spiritual_title),
                blurb = stringResource(id = R.string.resources_spiritual_blurb)
            )
        )
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_psychology_title),
                blurb = stringResource(id = R.string.resources_psychology_blurb)
            )
        )
        list.add(
            Resource(
                title= stringResource(id = R.string.resources_connect_title),
                blurb = stringResource(id = R.string.resources_connect_blurb)
            )
        )
        NoSad_Scaffold(
            content = { ResourceScreen(list = list, onSelectResource = {}) },
            onAddItem = {navController.navigate(ColorWheelScreenSpec.navigateTo())},
            onJournal = {},
            onMetrics = {navController.navigate(MetricScreenSpec.navigateTo())},
            onRecent = {navController.navigate(PastRecordsScreenSpec.navigateTo())},
            onSupport = {navController.navigate(ResourcesScreenSpec.navigateTo())},
            onHome = {navController.navigate(HomeScreenSpec.navigateTo())},
            onSettings = {},
            bottomBarItemNumber = 5
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