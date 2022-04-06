package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo

@Database(entities=[ProfileInfo::class], version=1)
@TypeConverters(NoSadTypeConverters::class)
abstract class ProfileInfoDatabase: RoomDatabase() {
    companion object {
        @Volatile private var INSTANCE: ProfileInfoDatabase? = null
        fun getInstance(context: Context): ProfileInfoDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(context, ProfileInfoDatabase::class.java,
                        "profile-info-database").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    abstract val profileInfoDao: ProfileInfoDao
}