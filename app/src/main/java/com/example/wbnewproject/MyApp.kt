package com.example.wbnewproject


import SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wbapplication.ui.VerificationCodeScreen
import com.example.wbnewproject.Interesting.InterestingScreen
import com.example.wbnewproject.nameinput.NameInputScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        //composable("interesting"){ InterestingScreen() }
        //composable("verificationCode"){ VerificationCodeScreen(navController = navController)}
        //composable("phoneNumber"){ PhoneNumberScreen(navController = navController)}

    }
}