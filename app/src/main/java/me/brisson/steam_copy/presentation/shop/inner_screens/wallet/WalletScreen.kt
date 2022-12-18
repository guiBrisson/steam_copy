package me.brisson.steam_copy.presentation.shop.inner_screens.wallet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WalletScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "WALLET", modifier = Modifier.align(Alignment.Center))
    }
}