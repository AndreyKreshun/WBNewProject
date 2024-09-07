package com.example.wbnewproject.nameinput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.wbnewproject.R
import com.example.wbnewproject.components.ScreenHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInputScreen(
    navController: NavController,
    viewModel: NameInputViewModel //= viewModel(NameInputViewModel::class.java)
) {
    val name by viewModel.name // Наблюдаем за состоянием имени

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(100.dp))
            ScreenHeader(
                titleResId = R.string.auth_title,
                descriptionResId = R.string.auth_description
            )
            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = name,
                onValueChange = { viewModel.onNameChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = { Text(text = "Введите ваше имя") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("nextScreen") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (name.isNotBlank()) Color(0xFF6200EE) else Color.Gray
                ),
                enabled = name.isNotBlank() // Кнопка активна только если имя введено
            ) {
                Text(text = "Продолжить", color = Color.White)
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun NameInputScreenPreview() {
    NameInputScreen(navController = rememberNavController())
}*/
