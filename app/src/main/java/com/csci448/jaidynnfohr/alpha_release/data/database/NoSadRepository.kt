package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo
import java.util.*
import java.util.concurrent.Executors

class NoSadRepository private constructor(private val noSadDao: NoSadDao) {
    companion object {
        @Volatile private var INSTANCE: NoSadRepository? = null
        fun getInstance(context: Context): NoSadRepository {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    val database = NoSadDatabase.getInstance(context)
                    instance = NoSadRepository(database.noSadDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val executor = Executors.newSingleThreadExecutor()

    //Journal Entry functions

    fun addEntry(entry: JournalEntry) {
        executor.execute {
            noSadDao.addEntry(entry)
        }
    }

    fun deleteEntry(entry: JournalEntry){
        executor.execute{
            noSadDao.deleteEntry(entry)
        }
    }

    fun getEntries(): LiveData<List<JournalEntry>> = noSadDao.getEntries()
    fun getEntry(id: UUID): LiveData<JournalEntry?> = noSadDao.getEntry(id)


    //Profile Info functions

    fun addProfile(profile: ProfileInfo) {
        executor.execute {
            noSadDao.addProfile(profile)
        }
    }
    fun getProfiles(): LiveData<List<ProfileInfo>> = noSadDao.getProfiles()
    fun getProfile(id: UUID): LiveData<ProfileInfo?> = noSadDao.getProfile(id)
}

