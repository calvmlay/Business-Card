package com.chuitec.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chuitec.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserInfo()
        Spacer(modifier = Modifier.size(240.dp))
        ContactInfo()
    }
}

@Composable
fun UserInfo() {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = "user image",
        modifier = Modifier
            .background(color = Color.Blue)
            .size(100.dp)
    )
    Text(
        text = "Jennifer Doe",
        fontSize = 54.sp,
        modifier = Modifier.padding(top = 10.dp)
    )
    Text(text = "Android Developer Extraordinaire")
}

@Composable
fun ContactInfo() {
    Column {
        Row() {
            Icon(
                painter = painterResource(R.drawable.baseline_local_phone_24),
                contentDescription = "phone icon"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "+11 (123) 444 555 666")
        }
        Row() {
            Icon(
                painter = painterResource(R.drawable.baseline_share_24),
                contentDescription = "share icon"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "@AndroidDev")
        }
        Row() {
            Icon(
                painter = painterResource(
                    R.drawable.baseline_email_24
                ),
                contentDescription = "email icon"
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "jen.doe@android.com")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}