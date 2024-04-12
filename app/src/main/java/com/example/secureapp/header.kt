package com.example.secureapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.secureapp.ui.theme.ThemeBlue

@Composable
fun Header(navController: NavController, context: Context, id: String){
    val names = mapOf(
        "SE1234" to "Константин",
        "HG6589" to "Андрей"
    )
    var name = names[id]
    if(name == null) name = "unknown"
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(55.dp)
        .background(ThemeBlue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
//            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ){
        Image(painter = painterResource(id = R.drawable.menu_bar), contentDescription = "Меню",
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp)
                .clickable {
                    Toast
                        .makeText(context, "Меню открыто", Toast.LENGTH_LONG)
                        .show()
                }
            ,)
        Text(text = name, color = Color.White, fontSize = 24.sp)
        Image(painter = painterResource(id = R.drawable.exit), contentDescription = "Выход",
            modifier = Modifier
                .padding(15.dp)
                .size(30.dp)
                .clickable { navController.navigate(Routes.loginScreen) }
            ,)
    }
}