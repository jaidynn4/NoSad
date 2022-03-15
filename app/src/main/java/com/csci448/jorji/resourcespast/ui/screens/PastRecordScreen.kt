package com.csci448.jorji.resourcespast.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.jorji.resourcespast.R
import com.csci448.jorji.resourcespast.data.PastRecord

class PastRecordScreen {
    @Composable
    fun PastRecordScreen(list : List<PastRecord>?, onSelectRecord:(PastRecord) -> Unit){
        if(list != null){
            LazyColumn{
                items(list){
                    record -> RecordRow(record = record, onSelectRecord = onSelectRecord)
                }
            }
        }
    }

    @Composable
    fun RecordRow(record: PastRecord,onSelectRecord: (PastRecord) -> Unit){
        Card(modifier =
        Modifier
            .clickable { onSelectRecord }
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
        ){
            Row{
                Text(text = record.getDate().toString())
                Column{
                    record.getTitle()?.let{
                        Row {
                            Card {
                                Text(text = it)
                                Text(text = record.getTextTime().toString())
                            }
                        }
                    }
                    record.getAudio()?.let{
                        Card {
                            Text(text = stringResource(id = R.string.record_audio_display_text))
                            Text(text = record.getAudioTime().toString())
                        }
                    }
                }
            }
        }
    }

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    private fun PreviewRecordList(){

    }
}