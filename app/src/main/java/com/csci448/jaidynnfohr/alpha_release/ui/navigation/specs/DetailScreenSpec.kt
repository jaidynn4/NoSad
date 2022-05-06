package com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs


import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.*
import com.csci448.jaidynnfohr.alpha_release.ui.LoginScreen
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

object DetailScreenSpec : IScreenSpec {

    override val route = "detail"
    override val arguments: List<NamedNavArgument> = mutableListOf()


    @Composable
    override fun Content(
        viewModel: NoSadViewModel,
        navController: NavController,
        navBackStackEntry: NavBackStackEntry,
        auth: FirebaseAuth
    ) {
        val loginSuccessful = viewModel.loginSuccessful.observeAsState()
        val scope = rememberCoroutineScope()
        LoginScreen(
            onLogin = {
                viewModel.signInWithEmailAndPassword()
                      },
            {navController.navigate(CreateScreenSpec.navigateTo())},
            {navController.navigate(ForgotPasswordScreenSpec.navigateTo())},
            avm = viewModel,
            onLoginSuccess = { navController.navigate(HomeScreenSpec.navigateTo())  },
            loginSuccessful = loginSuccessful
            )
    }

    override fun navigateTo(vararg args: String?): String {
        return route
    }

}
