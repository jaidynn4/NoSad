package com.csci448.jaidynnfohr.alpha_release

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
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
<<<<<<< Updated upstream

    private lateinit var auth: FirebaseAuth

=======
    companion object{
        private val BASE_URI = "https://nosad.csci448.edu"
        fun createPendingIntent(context : Context, targetScreen: String) : PendingIntent{
            val deepLinkIntent = Intent(
                Intent.ACTION_VIEW,
                "$BASE_URI$targetScreen".toUri(),
                context,
                MainActivity::class.java
            )

            val deepLinkPendingIntent = TaskStackBuilder.create(context).run{
                addNextIntentWithParentStack(deepLinkIntent)
                getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            }
            return deepLinkPendingIntent
        }
    }
>>>>>>> Stashed changes
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

