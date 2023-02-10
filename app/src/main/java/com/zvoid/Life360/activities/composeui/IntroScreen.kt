package com.zvoid.Life360.activities.composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.zvoid.Life360.R
import com.zvoid.Life360.ui.theme.Life360Theme
import com.zvoid.Life360.utilis.extensions.buildExoPlayer
import com.zvoid.Life360.utilis.extensions.buildExoPlayerView
import com.zvoid.Life360.utilis.extensions.getVideoUri


@Composable
fun IntroMessageF(message: String) {


    Text(
        text = "$message",
        color = Color.White,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(12.dp)
//
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen() {
    val context = LocalContext.current

    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent)

    val exoPlayer = remember { context.buildExoPlayer(getVideoUri(context)) }

    val pagerState = rememberPagerState()
    val introMessageList = listOf(
        "Share your location with your family in real-time",
        "Coordinate easily with smart notification",
        "Encourage safer driving with reports on speed, texting and more"
    )


    DisposableEffect(
        AndroidView(
            factory = { it.buildExoPlayerView(exoPlayer) }, modifier = Modifier.fillMaxSize()
        )
    ) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            //logo
            Icon(
                painter = painterResource(id = R.drawable.intro_logo),
                contentDescription = "logo",
                modifier = Modifier.size(140.dp),
                tint = Color.White
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
        ) {


            HorizontalPager(
                count = introMessageList.size,
                state = pagerState,
                contentPadding = PaddingValues(3.dp)
            ) { page ->
                // Our page content
                IntroMessageF(introMessageList[page])

            }

            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally), activeColor = Color.White,
                indicatorHeight = 12.dp,
                indicatorWidth = 12.dp,

                inactiveColor = Color.Gray
            )
            Button(
                onClick = { /*TODO*/


                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .fillMaxWidth(), shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 12.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    text = "Already have an account? ",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(24.dp, 24.dp, bottom = 24.dp)

                )
                Text(
                    text = "Sign In",
                    textAlign = TextAlign.Center,
                    color = Color.Yellow,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(end = 24.dp, top = 24.dp, bottom = 24.dp)
                )
            }


        }


    }


}

@Preview(showSystemUi = false)
@Composable
@Device
fun DefaultPreview() {
    Life360Theme {
        IntroScreen()
    }

}