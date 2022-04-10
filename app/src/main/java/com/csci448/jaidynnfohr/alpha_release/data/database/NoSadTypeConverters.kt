package com.csci448.jaidynnfohr.alpha_release.data.database

import androidx.compose.ui.graphics.Color
import androidx.room.TypeConverter
import java.util.*

class NoSadTypeConverters {

    @TypeConverter
    fun fromUUID(uuid: UUID?) = uuid?.toString()

    @TypeConverter()
    fun toUUID(uuidString: String?) = UUID.fromString(uuidString)

    @TypeConverter
    fun toDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time?.toLong()
    }

}