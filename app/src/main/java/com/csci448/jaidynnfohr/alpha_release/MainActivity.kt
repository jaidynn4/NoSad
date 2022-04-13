package com.csci448.jaidynnfohr.alpha_release

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.NoSadNavHost
import com.csci448.jaidynnfohr.alpha_release.ui.theme.Alpha_ReleaseTheme
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModel
import com.csci448.jaidynnfohr.alpha_release.viewmodels.NoSadViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = NoSadViewModelFactory(this)
        val noSadViewModel = ViewModelProvider(this, factory)
            .get(factory.getViewModelClass())
        setContent {
            Alpha_ReleaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                    MainActivityContent(noSadViewModel)
                }
            }
        }
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Composable
    fun MainActivityContent(noSadViewModel: NoSadViewModel){
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val navController = rememberNavController()
        NoSadNavHost().NoSadNavHost(viewModel = noSadViewModel, navController = navController)
    }

}

