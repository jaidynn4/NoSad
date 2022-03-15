package com.csci448.jorji.resourcespast.data

import android.provider.MediaStore
import androidx.compose.ui.res.stringResource
import com.csci448.jorji.resourcespast.R
import java.util.*


class PastRecord(id:UUID=UUID.randomUUID(), title:String?, date:Date, textEntry:String?, audio:MediaStore.Audio?) {
    private val recordID = id
    private var recordTitle = title
    private var recordDate = date
    private var recordText = textEntry
    private var recordAudio = audio

    fun getID() : UUID{
        return recordID
    }
    fun getTitle() : String?{
        if(recordTitle != null){
            return recordTitle
        }
        return null
    }
    fun getDate() : Date{
        return recordDate
    }
    fun getText() : String?{
        if(recordText != null){
            return recordText
        }
        return null
    }
    fun getAudio() : MediaStore.Audio?{
        if(recordAudio != null){
            return recordAudio
        }
        return null
    }
}