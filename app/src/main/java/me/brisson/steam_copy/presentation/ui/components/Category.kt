package me.brisson.steam_copy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.brisson.steam_copy.domain.model.Category
import me.brisson.steam_copy.domain.model.roguelikeCategory
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.presentation.ui.theme.montserrat

@Composable
fun GameCategory(
    modifier: Modifier = Modifier,
    category: Category,
    onClick: () -> Unit
) {
    val componentSize = 220.dp
    Box(modifier = modifier.size(componentSize).clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = category.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(componentSize * 0.6f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            category.color
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            text = category.name,
            style = TextStyle(
                fontFamily = montserrat,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview
@Composable
fun PreviewGameCategory() {
    SteamCopyTheme {
        GameCategory(category = roguelikeCategory, onClick = { })
    }
}