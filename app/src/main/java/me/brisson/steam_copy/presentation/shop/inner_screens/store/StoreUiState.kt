package me.brisson.steam_copy.presentation.shop.inner_screens.store

import me.brisson.steam_copy.domain.model.Category
import me.brisson.steam_copy.domain.model.Game

data class StoreUiState(
    val isLoading: Boolean = false,
    val highlightGames: List<Game> = emptyList(),
    val banner: String? = null,
    val specialOffers: List<Game> = emptyList(),
    val categories: List<Category> = emptyList(),
    val categoryButtons: List<String> = emptyList()
)