package com.example.wbnewproject.phonenumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wbnewproject.R
import com.example.wbnewproject.components.ScreenHeader

@Composable
fun PhoneNumberScreen(
    navController: NavController,
    viewModel: PhoneNumberViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // Подключение ViewModel
) {
    val selectedCountryCode by viewModel.selectedCountryCode
    val phoneNumber by viewModel.phoneNumber
    val expanded by viewModel.expanded

    val countryCodes = listOf(
        Pair("+7", R.drawable.russia_flag),
        Pair("+7", R.drawable.kazakhstan_flag),
        Pair("+374", R.drawable.armenia_flag),
        Pair("+373", R.drawable.flag_moldova)
    )

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Button(
                        onClick = { viewModel.onExpandedChange(!expanded) },
                        modifier = Modifier
                            .width(120.dp)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = countryCodes.find { it.first == selectedCountryCode }?.second ?: R.drawable.russia_flag),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(selectedCountryCode)
                            Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                        }
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { viewModel.onExpandedChange(false) }
                    ) {
                        countryCodes.forEach { (code, iconRes) ->
                            DropdownMenuItem(
                                onClick = {
                                    viewModel.onCountryCodeChange(code)
                                    viewModel.onExpandedChange(false)
                                },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = iconRes),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                text = { Text(text = code) }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = phoneNumber,
                    onValueChange = { viewModel.onPhoneNumberChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = { Text(text = "Введите номер телефона") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("verificationCodeScreen") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text(text = "Получить код", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberScreenPreview() {
    PhoneNumberScreen(navController = rememberNavController())
}
