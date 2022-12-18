package me.brisson.steam_copy.presentation.shop

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.brisson.steam_copy.presentation.shop.inner_screens.store.StoreScreen
import me.brisson.steam_copy.presentation.shop.inner_screens.wallet.WalletScreen
import me.brisson.steam_copy.presentation.shop.inner_screens.wishlist.WishlistScreen
import me.brisson.steam_copy.presentation.ui.components.DropdownShopMenu
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
    viewModel: ShopViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var expandedMenuDropdown by remember { mutableStateOf(false) }

    rememberSystemUiController().apply {
        setSystemBarsColor(color = MaterialTheme.colorScheme.surface)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            ShopHeader(
                onSearchTextChange = { },
                onSearch = { },
                onMenu = { expandedMenuDropdown = !expandedMenuDropdown },
                onStore = { viewModel.changeInnerScreen(InnerScreen.STORE_SCREEN) },
                onWishList = { viewModel.changeInnerScreen(InnerScreen.WISHLIST_SCREEN) },
                onWallet = { viewModel.changeInnerScreen(InnerScreen.WALLET_SCREEN) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            DropdownShopMenu(
                modifier = Modifier,
                expanded = expandedMenuDropdown,
                onDismissRequest = { expandedMenuDropdown = false },
                onYourStore = { },
                onTendencies = { },
                onCategory = { },
                onPointsStore = { },
                onNews = { },
                onLaboratory = { }
            )

            when (uiState.onInnerScreen) {
                InnerScreen.STORE_SCREEN -> StoreScreen()
                InnerScreen.WISHLIST_SCREEN -> WishlistScreen()
                InnerScreen.WALLET_SCREEN -> WalletScreen()
            }

        }
    }
}

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewHomeScreen() {
    SteamCopyTheme {
        ShopScreen()
    }
}