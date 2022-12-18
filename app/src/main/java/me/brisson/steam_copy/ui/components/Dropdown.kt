package me.brisson.steam_copy.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.steam_copy.R
import me.brisson.steam_copy.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.ui.theme.montserrat

@Composable
fun DropdownShopMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onYourStore: () -> Unit,
    onTendencies: () -> Unit,
    onCategory: () -> Unit,
    onPointsStore: () -> Unit,
    onNews: () -> Unit,
    onLaboratory: () -> Unit,
) {
    val textStyle = TextStyle(
        fontFamily = montserrat,
        color = Color.White,
        fontSize = 12.sp
    )
    Row(modifier.fillMaxWidth()) {
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF395E8A), Color(0xFF102268))
                    )
                ),
            expanded = expanded,
            onDismissRequest = onDismissRequest
        ) {
            DropdownMenuItem(
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .padding(end = 15.dp)
                                .size(15.dp),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://images.unsplash.com/photo-1615946027884-5b6623222bf4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80")
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.person_placeholder)
                        )
                        Text(text = "Sua loja", style = textStyle)
                    }
                },
                onClick = onYourStore ,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )

            DropdownMenuItem(
                text = { Text(text = "Novidades e tendências", style = textStyle) },
                onClick = onTendencies,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )
            DropdownMenuItem(
                text = { Text(text = "Categorias", style = textStyle) },
                onClick = onCategory,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )
            DropdownMenuItem(
                text = { Text(text = "Loja de pontos", style = textStyle) },
                onClick = onPointsStore,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )
            DropdownMenuItem(
                text = { Text(text = "Notícias", style = textStyle) },
                onClick = onNews,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )
            DropdownMenuItem(
                text = { Text(text = "Laboratório", style = textStyle) },
                onClick = onLaboratory,
                contentPadding = PaddingValues(horizontal = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewDropdown() {
    SteamCopyTheme {
        DropdownShopMenu(
            expanded = true,
            onDismissRequest = { },
            onYourStore = { },
            onTendencies = { },
            onCategory = { },
            onPointsStore = { },
            onNews = { },
            onLaboratory = { }
        )
    }
}