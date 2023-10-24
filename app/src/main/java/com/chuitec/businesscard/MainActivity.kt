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
        UserInfo(
            image = R.drawable.android_logo,
            imageDescription = R.string.user_image_description,
            fullName = R.string.full_name,
            designation = R.string.designation
        )
        Spacer(modifier = Modifier.size(240.dp))
        ContactInfo()
    }
}

@Composable
fun UserInfo(
    image: Int,
    imageDescription: Int,
    fullName: Int,
    designation: Int
) {
    Image(
        painter = painterResource(image),
        contentDescription = stringResource(imageDescription),
        modifier = Modifier
            .size(100.dp)
            .background(Color(0xFF073042))
    )
    Text(
        text = stringResource(fullName),
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = Color.Black
    )
    Text(
        text = stringResource(designation),
        color = Color(0xFF3DDC84)
    )
}

@Composable
fun ContactInfo() {
    Column {
        ContactRow(
            icon = R.drawable.baseline_local_phone_24,
            iconDescription = R.string.phone_number
        )
        Spacer(modifier = Modifier.size(10.dp))
        ContactRow(
            icon = R.drawable.baseline_share_24,
            iconDescription = R.string.username
        )
        Spacer(modifier = Modifier.size(10.dp))
        ContactRow(
            icon = R.drawable.baseline_mail_24,
            iconDescription = R.string.email
        )
    }
}

@Composable
fun ContactRow(icon: Int, iconDescription: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = stringResource(iconDescription),
            tint = Color(0xFF3DDC84)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = stringResource(iconDescription),
            color = Color.Black
        )
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