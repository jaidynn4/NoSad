package com.csci448.jaidynnfohr.alpha_release.ui.screens

import android.provider.MediaStore
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import com.csci448.jaidynnfohr.alpha_release.util.RecordGenerator

    @Composable
    fun PastRecordScreen(list : List<PastRecord>?, onSelectRecord:(PastRecord) -> Unit){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.record_screen_title),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
            Divider(
                thickness = 2.dp,
                color = colorResource(id = R.color.app_green_color)
            )
            Spacer(Modifier.height(24.dp))
            if (list != null) {
                LazyColumn {
                    items(list) { record ->
                        RecordRow(record = record, onSelectRecord = onSelectRecord)
                    }
                }
            }
        }
    }

    @Composable
    fun RecordRow(record: PastRecord,onSelectRecord: (PastRecord) -> Unit){
        Card(modifier =
        Modifier
            .clickable { onSelectRecord }
            .padding(8.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = 8.dp
        ){
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = record.getDate())
                    Spacer(Modifier.width(8.dp))
                    Text(text = record.getTextTime())
                    Column {

                    }
                }

                var title = ""
                record.getTitle()?.let {
                    title = it
                }
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    var color = record.getColor()
                    Text(text = title, color = color)
                }

                record.getAudio()?.let {
                    System.out.println("got audio")
                    //TODO
                }
                Row(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.record_audio_display_text))
                    Text(text = record.getAudioTime())
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun PreviewRecordList(){
//        val instance = PastRecordViewModel.getInstance()
//        val state = instance.DataLiveList.observeAsState()
        val list = mutableListOf<PastRecord>()
        for(i in 1..20){
            list.add(RecordGenerator.generateRandomRecord())
        }
        PastRecordScreen(list = list, onSelectRecord = {})
    }
