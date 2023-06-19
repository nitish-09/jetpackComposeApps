package com.example.firstapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}



@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)

    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(20.dp) ),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            //elevation = 4.dp
        ){
            Column( modifier = Modifier
                .padding(10.dp)
                .height(300.dp)
                .width(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()

                CreateInfo()
                Button(
                    onClick = {
                        //Log.d("Clicked", "CreateBizCard: Clicked")
                        buttonClickedState.value=!buttonClickedState.value


                     }
                ) {
                    Text(text = "Portfolio",
   //                 style=MaterialTheme.typography.button
                                 )
                    
                }
                if (buttonClickedState.value){
                    Content()
                }
                else{
                    Box{

                    }
                }
            }



        }

    }

}

@Preview
@Composable
fun Content(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){

        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner= CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)) {

            Portfolio(data= listOf("Project 1","Project 2","Project 3","Project 4"))


        }
    }

}


@Composable
fun Portfolio(data:List<String>){

    LazyColumn{
        items(data){
            item  ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            //elevation = 4.dp
                )
                {
                Row(modifier = Modifier
                    .padding(8.dp)
                   .background(MaterialTheme.colorScheme.background)
                    .padding(7.dp)) {

                   CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier=Modifier.padding(8.dp)
                        .align(alignment = CenterVertically)) {
                        Text(item, fontWeight = FontWeight.Bold)
                        Text("A Great Project", style = MaterialTheme.typography.titleMedium)
                        
                    }


                }
            }
        }
    }
}



@Composable
private fun CreateInfo() {
    Divider()
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Miles P.",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmmer",
            modifier = Modifier.padding(3.dp)
        )


        Text(
            text = "@theMilesCompose",
            modifier = Modifier.padding(3.dp),
            //                   style=MaterialTheme.typography.subtitle1
        )

    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier=Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp)
            .background(Color.Transparent),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),


        //tonalElevation = 4.dp
        shadowElevation = 20.dp,

        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstApplicationTheme {
        CreateBizCard()
    }
}