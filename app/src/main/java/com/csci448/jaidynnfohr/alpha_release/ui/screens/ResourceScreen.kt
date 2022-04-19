package com.csci448.jaidynnfohr.alpha_release.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.csci448.jaidynnfohr.alpha_release.R
import com.csci448.jaidynnfohr.alpha_release.data.Resource


@Composable
fun ResourceScreen(list : List<Resource>?, onSelectResource : (Resource) -> Unit){
    if(list != null) {
        LazyColumn(
            Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.resources_screen_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Divider(thickness = 2.dp, color = colorResource(id = R.color.app_green_color))
                Spacer(Modifier.height(24.dp))
                Text(
                    text = stringResource(id = R.string.resources_crisis_1),
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.resources_NSH),
                    fontSize = 20.sp
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.resources_crisis_2),
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.resources_local_hotline).format("#-###-###-####"),
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(24.dp))
            }
            items(list) { resource ->
                ResourceRow(resource = resource, onSelectResource = onSelectResource)
            }
            item{
                Text(text= stringResource(id = R.string.resources_socials), fontSize = 16.sp)
                Spacer(Modifier.height(8.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_facebook),
                        contentDescription = stringResource(id = R.string.resources_fb)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_instagram),
                        contentDescription = stringResource(id = R.string.resources_insta)
                    )
                    Image(painter = painterResource(
                        id = R.drawable.icon_twitter),
                        contentDescription = stringResource(id = R.string.resources_tw)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_reddit),
                        contentDescription = stringResource(id = R.string.resources_red)
                    )
                }
            }

        }
    }
}

@Composable
fun ResourceRow(resource: Resource, onSelectResource: (Resource) -> Unit){
    Button(
        onClick = { onSelectResource },
        Modifier.padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.app_green_color),
            contentColor = Color.White)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(resource.getTitle(), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(resource.getResourceBlurb())
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewResourceScreen(){
    val list = mutableListOf<Resource>()
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_medical_title),
            blurb = stringResource(id = R.string.resources_medical_blurb)
        )
    )
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_best_practices_title),
            blurb = stringResource(id = R.string.resources_best_practices_blurb)
        )
    )
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_stats_title),
            blurb = stringResource(id = R.string.resources_stats_blurb)
        )
    )
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_spiritual_title),
            blurb = stringResource(id = R.string.resources_spiritual_blurb)
        )
    )
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_psychology_title),
            blurb = stringResource(id = R.string.resources_psychology_blurb)
        )
    )
    list.add(
        Resource(
            title= stringResource(id = R.string.resources_connect_title),
            blurb = stringResource(id = R.string.resources_connect_blurb)
        )
    )
    ResourceScreen(list = list, onSelectResource = {})

}