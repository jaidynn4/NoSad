package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import java.util.*
import java.util.concurrent.Executors

class JournalEntryRepository private constructor(private val journalEntryDao: JournalEntryDao) {
    companion object {
        @Volatile private var INSTANCE: JournalEntryRepository? = null
        fun getInstance(context: Context): JournalEntryRepository {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    val database = JournalEntryDatabase.getInstance(context)
                    instance = JournalEntryRepository(database.journalEntryDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val executor = Executors.newSingleThreadExecutor()
    fun addEntry(entry: JournalEntry) {
        executor.execute {
            journalEntryDao.addEntry(entry)
        }
    }
    fun getEntries(): LiveData<List<JournalEntry>> = journalEntryDao.getEntries()
    fun getEntry(id: UUID): LiveData<JournalEntry?> = journalEntryDao.getEntry(id)
}

