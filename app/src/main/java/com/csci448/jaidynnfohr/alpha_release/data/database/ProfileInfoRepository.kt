package com.csci448.jaidynnfohr.alpha_release.data.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo
import java.util.*
import java.util.concurrent.Executors

class ProfileInfoRepository private constructor(private val profileInfoDao: ProfileInfoDao) {
    companion object {
        @Volatile private var INSTANCE: ProfileInfoRepository? = null
        fun getInstance(context: Context): ProfileInfoRepository {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    val database = ProfileInfoDatabase.getInstance(context)
                    instance = ProfileInfoRepository(database.profileInfoDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    private val executor = Executors.newSingleThreadExecutor()
    fun addProfile(profile: ProfileInfo) {
        executor.execute {
            profileInfoDao.addProfile(profile)
        }
    }
    fun getProfiles(): LiveData<List<ProfileInfo>> = profileInfoDao.getProfiles()
    fun getProfile(id: UUID): LiveData<ProfileInfo?> = profileInfoDao.getProfile(id)
}

