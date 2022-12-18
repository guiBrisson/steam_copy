package me.brisson.steam_copy.presentation.shop

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ShopUiState())
    val uiState: StateFlow<ShopUiState> = _uiState.asStateFlow()

    fun changeInnerScreen(innerScreen: InnerScreen) {
        _uiState.update { it.copy(onInnerScreen = innerScreen) }
    }
}