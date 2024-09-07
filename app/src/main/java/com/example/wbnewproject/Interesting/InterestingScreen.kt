package com.example.wbnewproject.Interesting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wbnewproject.R
import com.example.wbnewproject.components.ScreenHeader

@Composable
fun InterestingScreen(
    viewModel: InterestingViewModel = viewModel() // Получаем экземпляр ViewModel
) {
    val selectedTags = viewModel.selectedTags // Наблюдаем за состоянием выбранных тегов

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ScreenHeader(
            titleResId = R.string.interesting_title,
            descriptionResId = R.string.interesting_description
        )

        // Чипы
        MyChipsRow(
            tags = listOf(
                "Дизайн", "Разработка", "Продакт менеджмент", "Проджект менеджмент",
                "Backend", "Frontend", "Mobile", "Тестирование", "Продажи",
                "Бизнес", "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
            ),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) } // Передаем событие в ViewModel
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MyChipsRow(
    tags: List<String>,
    selectedTags: List<String>,
    onChipClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier,
        //mainAxisSpacing = 16.dp,
        //crossAxisSpacing = 8.dp
    ) {
        tags.forEach { tag ->
            CustomChip(
                text = tag,
                isSelected = selectedTags.contains(tag),
                onClick = { onChipClick(tag) }
            )
        }
    }
}

@Composable
fun CustomChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(
                vertical = 4.dp,
                horizontal = 2.dp
            )
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        color = if (isSelected) Color(0xFF6200EE) else Color.White
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 4.dp,
                    end = 8.dp,
                    bottom = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = if (isSelected) Color.White else Color(0xFF6200EE)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterestingScreenPreview() {
    InterestingScreen()
}
