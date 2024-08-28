
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun MyChipsRow(
    tags: List<String>,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
    ) {
        tags.forEach {
            CustomChip(
                text = it
            )
        }
    }
}

@Composable
fun CustomChip(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .padding(
                vertical = 4.dp,
                horizontal = 2.dp
            )
            .clip(RoundedCornerShape(16.dp)),

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
            )
        }
    }
}
