package com.chuitec.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
        contentDescription = stringResource(R.string.user_image_description),
        modifier = Modifier
            .size(100.dp)
            .background(Color(0xFF073042))
    )
    Text(
        text = stringResource(R.string.full_name),
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = Color.Black
    )
    Text(
        text = stringResource(R.string.designation),
        color = Color(0xFF3DDC84)
    )
}

@Composable
fun ContactInfo() {
    Column {
        Row() {
            Icon(
                painter = painterResource(R.drawable.baseline_local_phone_24),
                contentDescription = stringResource(R.string.phone_icon_description),
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(R.string.phone_number),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row() {
            Icon(
                painter = painterResource(R.drawable.baseline_share_24),
                contentDescription = stringResource(R.string.link_icon_description),
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(R.string.username),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Row() {
            Icon(
                painter = painterResource(R.drawable.baseline_mail_24),
                contentDescription = stringResource(R.string.email_icon_description),
                tint = Color(0xFF3DDC84)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(R.string.email),
                color = Color.Black
            )
        }
    }
}


@Preview(
    showBackground = false,
    showSystemUi = true
)
@Composable
fun  BusinessCardAppPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFFD2E8D4)
        ) {
            BusinessCardApp()
        }
    }
}