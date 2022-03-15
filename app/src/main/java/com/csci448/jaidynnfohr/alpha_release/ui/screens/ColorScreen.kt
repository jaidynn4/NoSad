package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.csci448.jaidynnfohr.alpha_release.R
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import com.csci448.jaidynnfohr.alpha_release.ui.theme.NoSad_Scaffold


//val countriesList = mutableListOf<String>(stringResource(R.string.love), "USA", "Canada", "Germany","Australia")
val labelChoice: String = ""

@Composable
private fun EmotionsDropDown(){
    var expanded by remember { mutableStateOf(false)}
    var emotion: String by remember { mutableStateOf(labelChoice) }

    Column(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "test",
            fontSize = 18.sp,
            modifier = Modifier.padding(end = 8.dp)
        )

        Icon(imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = ""
        )


        DropdownMenu(expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
        ) {

            DropdownMenuItem(
                onClick = {
                    expanded = false
                    //emotion = stringResource(id = R.string.love)
                }
            ){
                Text(text = stringResource(id = R.string.love))
            }


        //efficient way to do this - implement as string-array resource later
//            countriesList.forEach{ country->
//                DropdownMenuItem(onClick = {
//                    expanded = false
//                    countryName = country
//                }) {
//                    Text(text = country)
//                }
//            }
        }
    }
}


@Preview
@Composable
private fun PreviewColorWheelScreen() {
    NoSad_Scaffold { EmotionsDropDown() }
}