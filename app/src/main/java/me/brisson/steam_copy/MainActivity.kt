package me.brisson.steam_copy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import me.brisson.steam_copy.ui.theme.SteamCopyTheme

@ExperimentalAnimationApi
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SteamCopyTheme {
                AppNavGraph()
            }
        }
    }
}
