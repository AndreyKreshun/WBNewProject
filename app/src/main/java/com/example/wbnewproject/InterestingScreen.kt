package com.example.wbnewproject
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.lifecycle.viewmodel.compose.viewModel

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
        Text(
            text = stringResource(id = R.string.interesting_title),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.interesting_description),
            fontSize = 16.sp
        )

        // Чипы
        MyChipsRow(
            tags = listOf("Дизайн", "Разработка"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) } // Передаем событие в ViewModel
        )
        MyChipsRow(
            tags = listOf("Продакт менеджмент"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Проджект менеджмент"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Backend", "Frontend", "Mobile"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Тестирование", "Продажи"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Бизнес", "Безопасность"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Web", "Девопс", "Маркетинг"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
        MyChipsRow(
            tags = listOf("Аналитика"),
            selectedTags = selectedTags,
            onChipClick = { viewModel.onChipClick(it) }
        )
    }
}

@Composable
fun MyChipsRow(
    tags: List<String>,
    selectedTags: List<String>,
    onChipClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
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
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomButton(
            text = "Сохранить",
            isSelected = selectedTags.isNotEmpty(), // Проверка, есть ли выбранные теги
            onClick = { viewModel().saveData() }
        )
        CustomButton(
            text = "Расскажу позже",
            isSelected = true, // Эта кнопка всегда активна
            onClick = { /* Логика нажатия на кнопку "Расскажу позже" */ }
        )
    }

    }


    @Preview(showBackground = true)
    @Composable
    fun InterestingScreenPreview() {
        InterestingScreen()
    }
