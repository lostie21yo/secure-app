package com.example.secureapp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.secureapp.ui.theme.ThemeBlue

@Composable
fun ShiftScreenList(navController: NavController, context: Context, id: String) {
    Column (modifier = Modifier.fillMaxSize()) {
        Header(navController, context, id)
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .weight(weight = 1f, fill = false)) {
            ShiftListItem(context, navController, id,"ТЦ Европа", "Ленина, 7", "11.04.2024", "09:00", "20:00")
            ShiftListItem(context, navController, id, "Банк Гарант", "Советская, 235А", "12.04.2024", "08:00", "19:00")
        }

    }
}

@Composable
fun ShiftListItem(context: Context, navController: NavController, id: String, place: String, address: String, date: String, start: String, end: String,) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(6.dp)
            .clickable { navController.navigate(
                Routes.shiftScreen+"/${id}/${place}/${address}/${date}/${start}/${end}"
            )},
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        ){
            Row() {
                Column(modifier = Modifier.fillMaxWidth(0.7f).fillMaxHeight(),
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