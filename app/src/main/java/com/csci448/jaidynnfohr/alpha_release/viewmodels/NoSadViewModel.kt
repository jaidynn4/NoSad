package com.csci448.jaidynnfohr.alpha_release.viewmodels

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.data.database.NoSadRepository
import java.util.*

class NoSadViewModel(
    private val repository: NoSadRepository,
    context: Context
) : ViewModel() {

    //Store the in-progress color and string values from Add Mood page for transference to Journal Page
    var tempColorStorage: Color = Color.Unspecified
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
    //TODO refactor to be getting these amounts from the entries themselves?
    val colorList = mutableListOf<Color>()
    val moodList = mutableListOf<String>()

    val metricsColorList = mutableListOf<Color>()
    val metricsMoodList = mutableListOf<String>()

    val recordsList = mutableListOf<PastRecord>()

    fun getRecords(): LiveData<List<JournalEntry>> = repository.getEntries()


    fun addJournalEntry(entry: JournalEntry){
        repository.addEntry(entry)
    }

    fun deleteJournalEntry(entry: JournalEntry){
        repository.deleteEntry(entry)
    }

    fun populateRecord(color: Color, mood: String){
        //TODO
    }
}