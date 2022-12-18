package me.brisson.steam_copy.shop

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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.brisson.steam_copy.ui.components.DropdownShopMenu
import me.brisson.steam_copy.ui.theme.SteamCopyTheme

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun ShopScreen() {
    rememberSystemUiController().apply {
        setSystemBarsColor(color = MaterialTheme.colorScheme.surface)
    }

    var expandedMenuDropDown by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            ShopHeader(
                onSearchTextChange = { },
                onSearch = { },
                onMenu = { expandedMenuDropDown = !expandedMenuDropDown },
                onStore = { },
                onWishList = { },
                onWallet = { }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            DropdownShopMenu(
                modifier = Modifier,
                expanded = expandedMenuDropDown,
                onDismissRequest = { expandedMenuDropDown = false },
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