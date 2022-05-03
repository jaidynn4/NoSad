package com.csci448.jaidynnfohr.alpha_release.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo
import java.util.*

@Dao
interface NoSadDao {
    //Journal Entry Queries

    @Insert
    fun addEntry(entry: JournalEntry)

    @Query("SELECT * FROM entry")
    fun getEntries(): LiveData<List<JournalEntry>>

    @Query("SELECT * FROM entry WHERE id=(:id)")
    fun getEntry(id: UUID): LiveData<JournalEntry?>

    @Delete
    fun deleteEntry(entry: JournalEntry)


    //Profile Info Queries

    @Insert
    fun addProfile(profile: ProfileInfo)

    @Query("SELECT * FROM profile")
    fun getProfiles(): LiveData<List<ProfileInfo>>

    @Query("SELECT * FROM profile WHERE id=(:id)")
    fun getProfile(id: UUID): LiveData<ProfileInfo?>
}