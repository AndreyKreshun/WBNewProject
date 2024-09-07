import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.wbnewproject.R

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MapScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.cacheMode = WebSettings.LOAD_DEFAULT
                webViewClient = WebViewClient()

                // Загрузка Яндекс.Карт
                loadUrl("https://yandex.ru/maps/")
            }
        },
        update = { webView ->
            // Можно обновлять WebView при необходимости
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    MapScreen()
}