package com.zvoid.Life360.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material.*


import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.zvoid.Life360.navigation.StartNavigation
import com.zvoid.Life360.ui.theme.Life360Theme


class BaseNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Life360Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    WindowCompat.setDecorFitsSystemWindows(window, false)

                    StartNavigation()
                }
            }
        }
    }


}


