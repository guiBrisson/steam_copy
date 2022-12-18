package me.brisson.steam_copy.presentation.shop


data class ShopUiState(
    var onInnerScreen: InnerScreen = InnerScreen.STORE_SCREEN
)

enum class InnerScreen {
    STORE_SCREEN, WISHLIST_SCREEN, WALLET_SCREEN
}