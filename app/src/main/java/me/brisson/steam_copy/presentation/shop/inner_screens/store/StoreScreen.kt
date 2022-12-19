package me.brisson.steam_copy.presentation.shop.inner_screens.store

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.steam_copy.presentation.ui.components.GameCategory
import me.brisson.steam_copy.presentation.ui.components.GameTile
import me.brisson.steam_copy.presentation.ui.components.GameTileBig
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
                            SegmentTitle(
                                title = "DESTAQUES E RECOMENDADOS"
                            )
                            LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
                                items(games) { game ->
                                    GameTile(
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        game = game,
                                        onClick = { }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            uiState.banner?.let { banner ->
                item {
                    AsyncImage(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 20.dp)
                            .fillMaxWidth()
                            .clickable {  },
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(banner)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                    )
                }
            }

            uiState.specialOffers.let { games ->
                if (uiState.specialOffers.isNotEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                        ) {
                            SegmentTitle(
                                title = "OFERTAS ESPECIAIS",
                                onMore = { /*TODO*/ }
                            )

                            LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
                                items(games) { game ->
                                    GameTileBig(
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        game = game,
                                        onClick = { }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            uiState.categories.let { categories ->
                if (categories.isNotEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                        ) {
                            SegmentTitle(title = "EXPLORE POR CATEGORIA")

                            LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
                                items(categories) { category ->
                                    GameCategory(
                                        modifier = Modifier.padding(horizontal = 10.dp),
                                        category = category,
                                        onClick = { }
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