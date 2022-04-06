package com.csci448.jaidynnfohr.alpha_release.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.io.Serializable
import java.sql.Time

@Entity(tableName = "profile")
data class ProfileInfo(
    val userName: String,
    val passWord: String,
    val tutorialCompletion: Boolean,
    val emergencyContact: String,
    val newsEnabled: Boolean,
    val dailyReminderEnabled: Boolean,
    val scriptureEnabled: Boolean,
    val notificationTime: Time
) : Serializable{

    @PrimaryKey
    var id: UUID = UUID.randomUUID()
}
