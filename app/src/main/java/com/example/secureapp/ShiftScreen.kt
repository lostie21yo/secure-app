package com.example.secureapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun ShiftScreen(context: Context, navController: NavController, id: String, place: String,
                address: String, date: String, start: String, end: String,) {
    Column(modifier = Modifier
        .fillMaxSize()) {
        Header(navController, context, id)
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .background(Color.LightGray)
            ){
                Column () {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Объект: ", fontSize = 24.sp)
                        Text(text = place, fontSize = 24.sp)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Адрес: ", fontSize = 24.sp)
                        Text(text = address, fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Дата: ", fontSize = 24.sp)
                        Text(text = date, fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Начало смены: ", fontSize = 24.sp)
                        Text(text = start, fontSize = 24.sp)
                    }
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Конец смены: ", fontSize = 24.sp)
                        Text(text = end, fontSize = 24.sp)
                    }
                }
            }

            Button(onClick = { Toast.makeText(context, "Смена начата",Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .height(140.dp)
                    .width(140.dp),
                shape = RoundedCornerShape(70.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,       // цвет текста
                    containerColor = Color(0xff007f00))     // цвет фона
            ) {
                Text(text = "Начать\nсмену", fontSize = 24.sp, textAlign = TextAlign.Center)
            }

            Button(onClick = { navController.navigate(Routes.shiftScreenList+"/${id}") },
                modifier = Modifier
                    .height(50.dp)
                    .width(120.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,       // цвет текста
                    containerColor = Color(0xFF0357A6))     // цвет фона
            ) {
                Text(text = "Назад", fontSize = 18.sp)
            }
        }
    }
}