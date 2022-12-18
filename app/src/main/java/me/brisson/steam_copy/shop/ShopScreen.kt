package me.brisson.steam_copy.shop

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.brisson.steam_copy.ui.components.DropdownShopMenu
import me.brisson.steam_copy.ui.theme.SteamCopyTheme

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
                onStore = { },
                onWishList = { },
                onWallet = { }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if (uiState.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }

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