package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold


@Composable
private fun EmotionsWheel(){
    Column(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = Color.Blue,
                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                radius = size.minDimension / 2
            )
        }


//        Canvas(modifier = Modifier.fillMaxSize()) {
//            val canvasQuadrantSize = size / 2F
//            inset(50F, 30F) {
//                val canvasSize = size
//                val canvasWidth = size.width
//                val canvasHeight = size.height
//
//
//                withTransform({
//                    translate(left = canvasWidth / 5F)
//                    rotate(degrees = 45F)
//                }) {
//                    drawRect(
//                        color = Color.Gray,
//                        topLeft = Offset(x = canvasWidth / 3F, y = canvasHeight / 3F),
//                        size = canvasSize / 3F
//                    )
//                }
//            }
//        }


    }
}
