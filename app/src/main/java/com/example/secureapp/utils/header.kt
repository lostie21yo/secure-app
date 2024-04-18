package com.example.secureapp.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.secureapp.ui.theme.ThemeBlue

@Composable
fun Header(navController: NavController, context: Context, id: String){

    // заглушка БД, таблица имена (можно совместить с таблицей users)
    val names = mapOf(
        "SE1234" to "Константин",
        "HG5678" to "Андрей"
    )
    var name = names[id]
    if(name == null) name = "unknown"

    Box(modifier = Modifier.fillMaxWidth().background(ThemeBlue)) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .height(55.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
    //            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        ){
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        Toast
                            .makeText(context, "Меню открыто", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
            Text(text = name, color = Color.White, fontSize = 24.sp)
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .padding(5.dp)
                    .clickable { navController.navigate(Routes.loginScreen) },
            )
        }
    }
}