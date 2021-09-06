package com.example.helloworld

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greet()
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun MessageCard(greeting: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(text = greeting.author, color = MaterialTheme.colors.secondaryVariant,style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material.Surface(shape = MaterialTheme.shapes.medium,elevation = 1.dp) {

                Text(text = greeting.message,style = MaterialTheme.typography.body2)

            }
        }
    }
}

//@Preview(name = "Light Mode",showBackground = true)
@Preview(name = "Dark Mode",
uiMode = Configuration.UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun Greet() {
    MessageCard(greeting = Message("Shao Lin", "Welcome to Jetpack"))
}
