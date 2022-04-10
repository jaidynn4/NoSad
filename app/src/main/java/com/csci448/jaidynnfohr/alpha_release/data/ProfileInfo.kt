package com.csci448.jaidynnfohr.alpha_release.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.io.Serializable

@Entity(tableName = "profile")
data class ProfileInfo(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val userName: String,
    val passWord: String,
    val tutorialCompletion: Boolean,
    val emergencyContact: String,
    val newsEnabled: Boolean,
    val dailyReminderEnabled: Boolean,
    val scriptureEnabled: Boolean,
    val notificationTime: Long
) : Serializable
