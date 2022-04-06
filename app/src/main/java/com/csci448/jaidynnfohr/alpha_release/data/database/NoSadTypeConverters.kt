package com.csci448.jaidynnfohr.alpha_release.data.database

import androidx.room.TypeConverter
import java.util.*

class NoSadTypeConverters {

    @TypeConverter
    fun fromUUID(uuid: UUID?) = uuid?.toString()

    @TypeConverter()
    fun toUUID(uuidString: String?) = UUID.fromString(uuidString)
}