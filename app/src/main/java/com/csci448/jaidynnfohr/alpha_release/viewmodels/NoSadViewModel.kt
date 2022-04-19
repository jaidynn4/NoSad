package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.data.database.JournalEntryRepository
import com.csci448.jaidynnfohr.alpha_release.data.database.ProfileInfoRepository

class NoSadViewModel(
    private val journalEntryRepository: JournalEntryRepository,
    private val profileInfoRepository: ProfileInfoRepository,
    context: Context
) : ViewModel() {

    //Store the color and string value from Add Mood page for transference to Journal Page
    var tempColorStorage : Color = Color.Unspecified
    var tempStringStorage : String = ""

    //Store lists of color and string mood values added from Journal Page for access by Metrics
    val colorList = mutableListOf<Color>()
    val moodList = mutableListOf<String>()

    fun populateRecord(color: Color, mood: String){
        //TODO
    }

    //TODO pull the past x amount needed based on screen
    val metricsColorList = mutableListOf<Color>()
    val metricsMoodList = mutableListOf<String>()

    val recordsList = mutableListOf<PastRecord>()

    fun getRecords(): LiveData<List<JournalEntry>> = journalEntryRepository.getEntries()
}