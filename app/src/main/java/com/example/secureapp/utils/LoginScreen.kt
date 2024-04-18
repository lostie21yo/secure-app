package com.example.secureapp.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.secureapp.R

@Composable
fun LoginScreen(navController: NavController, context: Context) {

    var personID by remember {
        mutableStateOf("") // по умолчанию
    }

    var password by remember {
        mutableStateOf("") // по умолчанию
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Image(painter = painterResource(id = R.drawable.secure_icon), contentDescription = "Login Image",
            modifier = Modifier.size(200.dp))

        Text(text = "Добро пожаловать!", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(12.dp))
//        Text(text = "Войдите в свою учетную запись", fontSize = 18.sp)
//        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = personID, onValueChange = {personID = it}, label = {
            Text(text = "Идентификатор")
        })

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(value = password, onValueChange = {password = it}, label = {
            Text(text = "Пароль")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(18.dp))

        Button(onClick = { authentication(navController, personID, password, context) },
            modifier = Modifier.height(50.dp).width(120.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,       // цвет текста
                containerColor = Color(0xFF0357A6))     // цвет фона
        ) {
            Text(text = "Войти", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Забыли пароль?", modifier = Modifier.clickable {  })
    }
}

private fun authentication(navController: NavController, personID: String, password: String, context: Context) {
    // "заглушка" базы данных, таблица users (id юзера и пароль)
    val users = mapOf(
        "SE1234" to "pass1234",
        "HG5678" to "pass5678"
    )
    if(personID in users.keys && password == users[personID])
        navController.navigate(Routes.shiftScreenList +"/${personID}")
    else Toast.makeText(context, "Вход не выполнен!",Toast.LENGTH_LONG).show()
}