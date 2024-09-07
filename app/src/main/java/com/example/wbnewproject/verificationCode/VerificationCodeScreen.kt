package com.example.wbapplication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.wbnewproject.R
import com.example.wbnewproject.components.ScreenHeader
import com.example.wbnewproject.verificationCode.VerificationCodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationCodeScreen(navController: NavHostController,
                           viewModel: VerificationCodeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val code by viewModel.code

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Подтверждение") },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScreenHeader(
                    titleResId = R.string.auth_title,
                    descriptionResId = R.string.auth_description
                )
                Spacer(modifier = Modifier.height(32.dp))
                CodeInputField(code) { newCode ->
                    viewModel.onCodeChange(newCode)
                }
                Spacer(modifier = Modifier.height(32.dp))
                TextButton(onClick = { /* TODO: Handle resend code */ }) {
                    Text(
                        text = "Запросить код повторно",
                        color = Color(0xFF6200EE)
                    )
                }
            }
        }
    )
}

@Composable
fun CodeInputField(code: String, onCodeChange: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until 4) {
            val character = if (i < code.length) code[i].toString() else ""
            CodeInputBox(character) { newChar ->
                if (newChar.length <= 1) {
                    val newCode = code.take(i) + newChar + code.drop(i + 1)
                    onCodeChange(newCode)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeInputBox(character: String, onCharacterChange: (String) -> Unit) {
    TextField(
        value = character,
        onValueChange = onCharacterChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .size(50.dp)
            .background(Color.LightGray, CircleShape)
            .wrapContentSize(Alignment.Center),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            cursorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true
    )
}

/*@Preview(showBackground = true)
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(navController)
}*/
