package com.example.secureapp.utils

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// заглушка базы данных, таблица "смены"
val shifts = mapOf(
    "SE1234" to arrayOf(
        arrayOf("ТЦ Европа", "Ленина, 7", "11.04.2024", "09:00", "20:00"),
        arrayOf("Клуб Десятка", "10 лет октября, 92", "12.04.2024", "18:00", "04:00")
    ),
    "HG6589" to arrayOf(
        arrayOf("Банк Гарант", "Советская, 235А", "12.04.2024", "08:00", "19:00"),
        arrayOf("Парковка 5STARS", "Пушкинская, 65", "14.04.2024", "10:00", "22:00"),
        arrayOf("Отель Корстон", "Николая Ершова, 1А", "15.04.2024", "08:00", "20:00")
    ),
)

@Composable
fun ShiftScreenList(
    navController: NavController, context: Context, id: String,
) {
    val shiftList = shifts[id]
    Column (modifier = Modifier.fillMaxSize()) {
        Header(navController, context, id)
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .weight(weight = 1f, fill = false)) {
            if (!shiftList.isNullOrEmpty()) {
                for (shift in shiftList){
                    ShiftListItem(context, navController, id, shift)
                }
            }
            else {
                Column(modifier = Modifier.fillMaxWidth().height(600.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Нет запланированных смен", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun ShiftListItem(context: Context, navController: NavController, id: String, shift: Array<String>) {
    val place = shift[0]
    val address = shift[1]
    val date = shift[2]
    val start = shift[3]
    val end = shift[4]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate(
                    Routes.shiftScreen + "/${id}/${place}/${address}/${date}/${start}/${end}"
                )
            },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        ){
            Row() {
                Column(modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = place, fontSize = 22.sp)
                    Text(text = address, fontSize = 18.sp)
                }
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = date, fontSize = 18.sp)
                    Text(text = "$start - $end", fontSize = 18.sp)
                }
            }
        }
    }
}