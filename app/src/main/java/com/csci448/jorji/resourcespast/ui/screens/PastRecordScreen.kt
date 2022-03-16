package com.csci448.jorji.resourcespast.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csci448.jorji.resourcespast.R
import com.csci448.jorji.resourcespast.data.PastRecord
import com.csci448.jorji.resourcespast.util.RecordGenerator

class PastRecordScreen {
    @Composable
    fun PastRecordScreen(list : List<PastRecord>?, onSelectRecord:(PastRecord) -> Unit){
        Column {
            Text(text = stringResource(id = R.string.record_screen_title), fontSize = 24.sp)
            Divider(thickness = 2.dp, color = colorResource(id = R.color.black))
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
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(3.dp)
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = record.getDate())
                Spacer(Modifier.width(8.dp))
                Column {
                    record.getTitle()?.let {
                        Row(
                            Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(text = it)
                            Text(text = record.getTextTime())
                        }
                    }
                    record.getAudio()?.let {
                        System.out.println("got audio")
                        Row(
                            Modifier
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
}