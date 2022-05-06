package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.*
import androidx.navigation.compose.rememberNavController
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.data.database.NoSadRepository
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.DetailScreenSpec
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.HomeScreenSpec
import com.csci448.jaidynnfohr.alpha_release.ui.navigation.specs.IScreenSpec
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.util.*

class NoSadViewModel(
    private val repository: NoSadRepository,
    context: Context
) : ViewModel() {

    val context = context

    //Store the in-progress color id and string values from Add Mood page for transference to Journal Page
    var tempColorIdStorage: Int = R.color.white
    var tempStringStorage: String = ""

    //Store the in-progress title and thoughts values from Journal page for transference to Add Mood Page
    var tempTitleStorage: String = ""
    var tempThoughtsStorage: String = ""


    //LiveData calls using queries

    val journalEntryListLiveData = repository.getEntries()

    private val _entryIdLiveData = MutableLiveData<UUID>()

    val entryLiveData: LiveData<JournalEntry?> =
        Transformations.switchMap(_entryIdLiveData){
                entryId -> repository.getEntry(entryId)
        }

    fun loadEntry(id: UUID){
        _entryIdLiveData.value = id
    }



    //Store lists of color and string mood values added from Journal Page for access by Metrics
    //TODO refactor to be getting these amounts from the entries themselves
    val colorIdList = mutableListOf<Int>()
    val moodList = mutableListOf<String>()




    val metricsColorIdList = mutableListOf<Int>()
    val metricsMoodList = mutableListOf<String>()

    //TODO delete eventually
    init{
        for(i in 1..30) {
            colorIdList.add(R.color.metrics_dark_grey_color)
        }
        metricsColorIdList.add(R.color.love_red_color)
        metricsColorIdList.add(R.color.anger_orange_color)
        metricsColorIdList.add(R.color.anger_orange_color)
        metricsColorIdList.add(R.color.surprise_green_color)
        metricsColorIdList.add(R.color.joy_yellow_color)
        metricsColorIdList.add(R.color.anger_orange_color)
    }

    val recordsList = mutableListOf<PastRecord>()

    fun getRecords(): LiveData<List<JournalEntry>> = repository.getEntries()

    val journalEntriesListLiveData = repository.getEntries()

    fun addJournalEntry(entry: JournalEntry){
        repository.addEntry(entry)
    }

    fun deleteJournalEntry(entry: JournalEntry){
        repository.deleteEntry(entry)
    }

    fun populateRecord(color: Color, mood: String){
        //TODO
    }

    //authentication
    private val _isLoggedIn = MutableLiveData(false)
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn
    private val _error = mutableStateOf("")
    val error: State<String> = _error
    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail
    private val _password = mutableStateOf("")
    val password: State<String> = _password
    // Setters
    fun setUserEmail(email: String) {
        _userEmail.value = email
    }
    fun setPassword(password: String) {
        _password.value = password
    }
    fun setError(error: String) {
        _error.value = error
    }
    init {
        _isLoggedIn.value = getCurrentUser() != null
    }
    fun createUserWithEmailAndPassword() = viewModelScope.launch {
        _error.value = ""
        Firebase.auth.createUserWithEmailAndPassword(userEmail.value, password.value)
            .addOnCompleteListener { task -> signInCompletedTask(task) }
    }

    fun signInWithEmailAndPassword() = viewModelScope.launch {
        try {
            _error.value = ""
            Firebase.auth.signInWithEmailAndPassword(userEmail.value, password.value)
                .addOnCompleteListener { task -> signInCompletedTask(task) }
        } catch (e: Exception) {
            _error.value = e.localizedMessage ?: "Unknown error"
            Log.d("AUTH", "Sign in fail: $e")
        }
    }

    private val _loginSuccessful = MutableLiveData(false)
    val loginSuccessful: LiveData<Boolean> = _loginSuccessful

    private fun signInCompletedTask(task: Task<AuthResult>){
        if (task.isSuccessful) {
            Log.d("AUTH", "SignInWithEmail:success")
            _loginSuccessful.value = true
        } else {
            _loginSuccessful.value = false
            _error.value = task.exception?.localizedMessage ?: "Unknown error"
            val toast = Toast(context)
            toast.setText("Sign-in Error")
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
            Log.w("AUTH", "SignInWithEmail:failure", task.exception)

        }
        viewModelScope.launch {
            _isLoggedIn.value = getCurrentUser() != null
        }
    }
    private fun getCurrentUser() : FirebaseUser? {
        val user = Firebase.auth.currentUser
        Log.d("AUTH", "user display name: ${user?.displayName}, email: ${user?.email}")
        return user
    }
    fun isValidEmailAndPassword() : Boolean {
        if (userEmail.value.isBlank() || password.value.isBlank()) {
            return false
        }
        return true
    }

    fun resetLoginSuccessful() {
        _loginSuccessful.value = false
    }

    fun updateAccountEmail() {
        viewModelScope.launch {
            try {
                _error.value = ""
                Firebase.auth.currentUser?.updateEmail(userEmail.value)
                    ?.addOnCompleteListener { task ->
                        val toast = Toast(context)
                        if (task.isSuccessful) {
                            toast.setText("Email Updated")
                        } else {
                            toast.setText("Failed to Update Email")
                        }
                        toast.duration = Toast.LENGTH_SHORT
                        toast.show()

                    }
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Unknown error"
                Log.d("AUTH", "Sign in fail: $e")
            }
        }
    }

    fun updateAccountPassword() {
        viewModelScope.launch {
            try {
                _error.value = ""
                Firebase.auth.currentUser?.updatePassword(password.value)
                    ?.addOnCompleteListener { task ->
                        val toast = Toast(context)
                        if (task.isSuccessful) {
                            toast.setText("Password Updated")
                        } else {
                            toast.setText("Failed to Update Password")
                        }
                        toast.duration = Toast.LENGTH_SHORT
                        toast.show()


                    }
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Unknown error"
                Log.d("AUTH", "Sign in fail: $e")
            }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            try {
                _error.value = ""
                Firebase.auth.signOut()
                val toast = Toast(context)
                toast.setText("Signed Out")
                toast.duration = Toast.LENGTH_SHORT
                toast.show()
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Unknown error"
                Log.d("AUTH", "Sign out fail: $e")
            }
        }
    }

    fun updateBoth() {
        viewModelScope.launch {
            try {
                _error.value = ""
                Firebase.auth.currentUser?.updateEmail(userEmail.value)
                    ?.addOnCompleteListener { task ->
                        val toast = Toast(context)
                        if (task.isSuccessful) {
                            toast.setText("Email Updated")
                        } else {
                            toast.setText("Failed to Update Email")
                        }
                        toast.duration = Toast.LENGTH_SHORT
                        toast.show()
                        viewModelScope.launch {
                            try {
                                _error.value = ""
                                Firebase.auth.currentUser?.updatePassword(password.value)
                                    ?.addOnCompleteListener { task ->
                                        val toast = Toast(context)
                                        if (task.isSuccessful) {
                                            toast.setText("Password Updated")
                                        } else {
                                            toast.setText("Failed to Update Password")
                                        }
                                        toast.duration = Toast.LENGTH_SHORT
                                        toast.show()


                                    }
                            } catch (e: Exception) {
                                _error.value = e.localizedMessage ?: "Unknown error"
                                Log.d("AUTH", "Sign in fail: $e")
                            }
                        }
                    }
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Unknown error"
                Log.d("AUTH", "Sign in fail: $e")
            }
        }
    }


}