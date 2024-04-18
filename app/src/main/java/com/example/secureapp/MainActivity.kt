package com.example.secureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.secureapp.utils.LoginScreen
import com.example.secureapp.utils.Routes
import com.example.secureapp.utils.ShiftScreen
import com.example.secureapp.utils.ShiftScreenList

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
                composable(
                    Routes.shiftScreen+"/{id}/{place}/{address}/{date}/{start}/{end}/{isWorking}",
                        arguments = listOf(
                            navArgument("id") { type = NavType.StringType },
                            navArgument("place") { type = NavType.StringType },
                            navArgument("address") { type = NavType.StringType },
                            navArgument("date") { type = NavType.StringType },
                            navArgument("start") { type = NavType.StringType },
                            navArgument("end") { type = NavType.StringType },
                            navArgument("isWorking") { type = NavType.BoolType },

                        )
                    ) {backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id")
                        val place = backStackEntry.arguments?.getString("place")
                        val address = backStackEntry.arguments?.getString("address")
                        val date = backStackEntry.arguments?.getString("date")
                        val start = backStackEntry.arguments?.getString("start")
                        val end = backStackEntry.arguments?.getString("end")
                        val isWorking = backStackEntry.arguments?.getBoolean("isWorking")


                    ShiftScreen(context, navController,  id?: "N/A", place?: "N/A",
                        address?: "N/A", date?: "N/A",
                        start?: "N/A", end?: "N/A", isWorking?: false)
                }
            })
        }
    }


}

