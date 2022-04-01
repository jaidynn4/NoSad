package com.csci448.jaidynnfohr.alpha_release.data

import android.provider.MediaStore
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.csci448.jaidynnfohr.alpha_release.R

import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.*


class PastRecord(id:UUID=UUID.randomUUID(), title:String?, date:LocalDate, textTime:LocalTime, audioTime:LocalTime,textEntry:String?, audio:MediaStore.Audio?) {
    private val recordID = id
    private var recordTitle = title
    private var recordDate = date
    private var recordText = textEntry
    private var recordAudio = audio
    private var recordTextTime = textTime
    private var recordAudioTime = audioTime

    fun getID() : UUID{
        return recordID
    }

    @Composable
    fun getTitle() : String?{
        if(recordTitle != null){
            return recordTitle
        }
        else if (recordTitle == null && recordAudio != null) return null
        else return stringResource(id = R.string.record_title_placeholder)
    }

    @Composable
    fun getDate() : String{
        return stringResource(id = R.string.record_date_formatter)
            .format(recordDate.month.toString(),
                recordDate.dayOfMonth.toString(),
                recordDate.year.toString())
    }

    @Composable
    fun getTextTime() : String {
        if(recordTitle != null)
        {
            val partOfDay: String
            val hour: String
            val minute: String
            if (recordTextTime.hour >= 12) {
                partOfDay = "PM"
                hour = (recordTextTime.hour - 12).toString()
            } else {
                partOfDay = "AM"
                hour = recordTextTime.hour.toString()
            }
            if (recordTextTime.minute <= 9) {
                minute = "0${recordTextTime.minute}"
            } else {
                minute = recordTextTime.minute.toString()
            }
            return stringResource(id = R.string.record_time_formatter).format(
                hour,
                minute,
                partOfDay
            )
        }
        else return ""
    }

    @Composable
    fun getAudioTime() : String {
        if(recordAudio != null) {
            val partOfDay: String
            val hour: String
            val minute: String
            if (recordAudioTime.hour >= 12) {
                partOfDay = "PM"
                hour = (recordAudioTime.hour - 12).toString()
            } else {
                partOfDay = "AM"
                hour = recordAudioTime.hour.toString()
            }
            if (recordAudioTime.minute <= 9) {
                minute = "0${recordAudioTime.minute}"
            } else {
                minute = recordAudioTime.minute.toString()
            }
            return stringResource(id = R.string.record_time_formatter).format(
                hour,
                minute,
                partOfDay
            )
        }
        else{
            return ""
        }
    }

    @Composable
    fun getText(): String? {
        if (recordText != null) {
            return recordText
        }
        return stringResource(id = R.string.record_text_entry_placeholder)
    }

    fun getAudio() : MediaStore.Audio?{
        if(recordAudio != null){
            return recordAudio
        }
        return null
    }

    fun setText(newText:String){
        recordText = newText
    }

    fun setTitle(newTitle:String){
        recordTitle = newTitle
    }

    fun setTextTime(newTextTime:LocalTime){
        recordTextTime = newTextTime
    }

    fun setAudioTime(newAudioTime:LocalTime){
        recordAudioTime = newAudioTime
    }
}