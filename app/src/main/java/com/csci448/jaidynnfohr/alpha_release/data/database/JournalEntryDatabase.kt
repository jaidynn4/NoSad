package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry

@Database(entities=[JournalEntry::class], version=1)
@TypeConverters(NoSadTypeConverters::class)
abstract class JournalEntryDatabase: RoomDatabase() {
    companion object {
        @Volatile private var INSTANCE: JournalEntryDatabase? = null
        fun getInstance(context: Context): JournalEntryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context, JournalEntryDatabase::class.java,
                        "journal-entry-database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val journalEntryDao: JournalEntryDao
}