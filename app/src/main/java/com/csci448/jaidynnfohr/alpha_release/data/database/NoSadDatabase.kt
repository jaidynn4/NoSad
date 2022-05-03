package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csci448.jaidynnfohr.alpha_release.data.JournalEntry
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo

@Database(entities=[JournalEntry::class, ProfileInfo::class], version=1)
@TypeConverters(NoSadTypeConverters::class)
abstract class NoSadDatabase: RoomDatabase() {
    companion object {
        @Volatile private var INSTANCE: NoSadDatabase? = null
        fun getInstance(context: Context): NoSadDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context, NoSadDatabase::class.java,
                        "no-sad-database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val noSadDao: NoSadDao
}