package com.example.tarjeta_presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjeta_presentacion.ui.theme.Tarjeta_PresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tarjeta_PresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PresentationCard(name = getString(R.string.name), cargo= getString(R.string.cargo),
                        number = getString(R.string.number), social = getString(R.string.social), email = getString(
                            R.string.email
                        ))

                }
            }
        }
    }
}

@Composable
fun PresentationCard(name: String, cargo: String, number: String, social: String, email: String) {
    val image = painterResource(R.drawable.android_logo)
    Column (modifier = Modifier
        .fillMaxHeight()
        .background(Color(212, 232, 212)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .background(Color(16, 48, 66))
                    .size(width = 120.dp, height = 120.dp)
            ) {
                Image(painter = image, contentDescription = null)
            }
            Text(
                text = name,
                fontSize = 35.sp, modifier = Modifier
                    .padding(top = 12.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = cargo,
                fontSize = 17.sp,
                color = Color(71, 133, 88),
                modifier = Modifier
                    .padding(4.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold
            )
        }

        Column (verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(bottom = 32.dp)
        ){
            Row (modifier = Modifier.padding(8.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.phone_black_24dp),
                    contentDescription = null,
                    tint = Color(71, 133, 88)
                )

                Text(
                    text = number,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

            Row (modifier = Modifier.padding(8.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.share_black_24dp),
                    contentDescription = null,
                    tint = Color(71, 133, 88)
                )

                Text(
                    text = social,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }

            Row (modifier = Modifier.padding(8.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.email_black_24dp),
                    contentDescription = null,
                    tint = Color(71, 133, 88)
                )

                Text(
                    text = email,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PresentationCardPreview() {
    Tarjeta_PresentacionTheme {
        PresentationCard(name = "Lucia Martinez", cargo="Android Developer Extraordinaire",
            number = "+51 999999999", social = "@LuciaMartinez", email = "luciamartinez123@gmail.com")
    }
}