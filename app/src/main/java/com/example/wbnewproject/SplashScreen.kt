import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Запускаем эффект для перехода на главный экран
    LaunchedEffect(Unit) {
        delay(3000) // Задержка на 3 секунды
        navController.navigate("verificationCode") {
            popUpTo("splash") { inclusive = true }
        }
    }

    // Ваша текущая реализация сплэш-скрина
    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    val infiniteTransition = rememberInfiniteTransition()
    val animatedGradient = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing)
        )
    )

    val gradientColors = listOf(
        Color(0xFF8A2BE2), // Фиолетовый цвет
        Color(0xFF4B0082)  // Тёмно-фиолетовый/индиго цвет
    )

    val brush = Brush.linearGradient(
        colors = gradientColors,
        start = Offset(200f, 200f),
        end = Offset(800f * animatedGradient.value, 800f * animatedGradient.value)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "WB\nвстречи",
            fontSize = 40.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                //.background(Color.Black)
                .padding(24.dp)
        )
    }
}
