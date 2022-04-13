package com.csci448.jaidynnfohr.alpha_release.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.io.Serializable

@Entity(tableName = "entry")
data class JournalEntry(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val journal_title: String,
    val journal_entry: String,
    val journal_timestamp: Date,
    val mood_selected: String,
    val mood_color: Int //getResources().getColor(mood_color)
) : Serializable
