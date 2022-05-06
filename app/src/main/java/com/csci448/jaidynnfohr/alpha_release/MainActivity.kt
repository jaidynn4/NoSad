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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
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

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            //reload();
        }
    }

    @SuppressLint("SourceLockedOrientationActivity")
    @Composable
    fun MainActivityContent(noSadViewModel: NoSadViewModel){
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val navController = rememberNavController()
        NoSadNavHost().NoSadNavHost(viewModel = noSadViewModel,
            navController = navController,
            auth = auth)
    }

}

