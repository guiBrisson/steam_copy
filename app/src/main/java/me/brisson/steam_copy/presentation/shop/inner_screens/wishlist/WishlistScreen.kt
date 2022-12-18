package me.brisson.steam_copy.presentation.shop.inner_screens.wishlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WishlistScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "WISHLIST", modifier = Modifier.align(Alignment.Center))
    }
}