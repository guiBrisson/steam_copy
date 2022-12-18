package me.brisson.steam_copy.presentation.shop.inner_screens.store

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.brisson.steam_copy.domain.model.*
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(StoreUiState())
    val uiState: StateFlow<StoreUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { it.copy(isLoading = true) }
        getHighlightGames()
        getBanner()
    }

    private fun getBanner() {
        _uiState.update {
            it.copy(
                isLoading = false,
                banner = "https://cdn.akamai.steamstatic.com/steam/clusters/takeunder/1d9be6494084c7c75cc6bcde/takeunder_mobile_english.jpg?t=1671047818"
            )
        }
    }

    private fun getHighlightGames() {
        val games = listOf(
            spiderManGame,
            finalFantasyGame,
            huntShowdownGame,
            multiVersusGame,
            hogwartsLegacyGame
        )

        _uiState.update { it.copy(isLoading = false, highlightGames = games) }
    }
}