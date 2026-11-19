package com.example.mygoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mygoal.ui.screens.MainScreen
import com.example.mygoal.ui.theme.MyGoalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyGoalTheme {
                MainScreen()
            }
        }
    }
}
