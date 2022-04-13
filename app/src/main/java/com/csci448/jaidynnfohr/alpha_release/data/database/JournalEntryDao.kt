package com.csci448.jaidynnfohr.alpha_release.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import java.util.*

@Dao
interface JournalEntryDao {
    @Insert
    fun addEntry(entry: JournalEntry)

    @Query("SELECT * FROM entry")
    fun getEntries(): LiveData<List<JournalEntry>>

    @Query("SELECT * FROM entry WHERE id=(:id)")
    fun getEntry(id: UUID): LiveData<JournalEntry?>
}