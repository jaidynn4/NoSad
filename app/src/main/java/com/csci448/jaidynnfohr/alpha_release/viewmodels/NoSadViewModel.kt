package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.data.database.JournalEntryRepository
import com.csci448.jaidynnfohr.alpha_release.data.database.ProfileInfoRepository

class NoSadViewModel(
    private val journalEntryRepository: JournalEntryRepository,
    private val profileInfoRepository: ProfileInfoRepository,
    context: Context
) : ViewModel() {

    val colorList = mutableListOf<Color>()
    val moodList = mutableListOf<String>()

    fun populateRecord(color: Color, mood: String){
        //TODO
    }

    //TODO pull the past x amount needed based on screen
    val metricsColorList = mutableListOf<Color>()
    val metricsMoodList = mutableListOf<String>()

    val recordsList = mutableListOf<PastRecord>()
}