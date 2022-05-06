package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs

import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.screens.ForgotPasswordScreen
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth

object ForgotPasswordScreenSpec : IScreenSpec {

    override val route = "forgot"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        auth: FirebaseAuth
    ) {
        ForgotPasswordScreen { navController.navigate(DetailScreenSpec.navigateTo()) }
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