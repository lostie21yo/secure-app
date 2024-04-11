package com.example.secureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = this.applicationContext
            NavHost(navController = navController, startDestination = Routes.loginScreen, builder = {
                composable(Routes.loginScreen, ) { LoginScreen(navController, context) }
                composable(Routes.shiftScreenList+"/{id}", ) {
                    val id = it.arguments?.getString("id")
                    ShiftScreenList(navController, context, id?: "N/A")
                }
            })
        }
    }


}

