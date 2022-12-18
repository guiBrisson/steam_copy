package me.brisson.steam_copy.presentation.shop.inner_screens.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.steam_copy.presentation.ui.components.GameTile
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A2B3C))
    ) {
        if (uiState.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {

            uiState.highlightGames.let { games ->
                if (games.isNotEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF1D3E5D))
                                .padding(vertical = 20.dp),
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp, start = 20.dp),
                                text = "DESTAQUES E RECOMENDADOS",
                                style = TextStyle(
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontSize = 14.sp
                                )
                            )
                            LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
                                items(games) { game ->
                                    GameTile(
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        game = game
                                    )
                                }
                            }
                        }
                    }
                }
            }


        }

    }
}

@Preview
@Composable
fun PreviewStoreScreen() {
    SteamCopyTheme {
        StoreScreen()
    }
}