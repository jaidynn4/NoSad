package com.csci448.jorji.resourcespast.data

import android.provider.MediaStore
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.csci448.jorji.resourcespast.R
import java.time.chrono.ChronoLocalDateTime
import java.util.*


class PastRecord(id:UUID=UUID.randomUUID(), title:String?, date:Date, textTime:Date, audioTime:Date,textEntry:String?, audio:MediaStore.Audio?) {
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
        return stringResource(id = R.string.record_title_placeholder)
    }
    
    fun getDate() : Date{
        return recordDate
    }

    fun getTextTime() : Long {
        return recordTextTime.time
    }

    fun getAudioTime() : Long {
        return recordAudioTime.time
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
}