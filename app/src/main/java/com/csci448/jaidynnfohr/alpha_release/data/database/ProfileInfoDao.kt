package com.csci448.jaidynnfohr.alpha_release.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.csci448.jaidynnfohr.alpha_release.data.ProfileInfo
import java.util.*

@Dao
interface ProfileInfoDao {
    @Insert
    fun addProfile(profile: ProfileInfo)

    @Query(value = "SELECT * FROM profile")
    fun getProfiles(): LiveData<List<ProfileInfo>>

    @Query(value = "SELECT * FROM profile WHERE id=(:id)")
    fun getProfile(id: UUID): LiveData<ProfileInfo?>
}