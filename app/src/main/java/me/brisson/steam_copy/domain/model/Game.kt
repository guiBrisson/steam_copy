package me.brisson.steam_copy.domain.model

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase

data class Game(
    val name: String,
    val image: String,
    val priceHistory: List<Float>?,
    val currentPrice: Float?
)

val finalFantasyGame = Game(
    name = "final fantasy vii remake intergrade".toUpperCase(Locale.current),
    image = "https://cdn.cloudflare.steamstatic.com/steam/apps/1462040/capsule_616x353.jpg?t=1663767129",
    priceHistory = listOf(349.90f),
    currentPrice = 199.44f
)

val spiderManGame = Game(
    name = "Marvel's Spider-Man Remastered",
    image = "https://cdn1.epicgames.com/offer/4bc43145bb8245a5b5cc9ea262ffbe0e/EGS_MarvelsSpiderManRemastered_InsomniacGamesNixxesSoftware_S1_2560x1440-73702d11161b29a0b7c40a8b489b1808",
    priceHistory = listOf(249.90f),
    currentPrice = 187.42f
)

val huntShowdownGame = Game(
    name = "Hunt: Showdown",
    image = "https://pbs.twimg.com/media/Fj8nBWQXkAEpefq?format=jpg&name=large",
    priceHistory = listOf(89f),
    currentPrice = 35.60f
)

val multiVersusGame = Game(
    name = "MultiVersus",
    image = "https://cdn1.epicgames.com/offer/3a212c0da4f1438e840c21565df4b6fe/EGS_MultiVersus_PlayerFirstGames_S1_2560x1440-0c97c9a155748f90f13fc0dd484ccc48",
    priceHistory = null,
    currentPrice = null
)

val hogwartsLegacyGame = Game(
    name = "Hogwarts Legacy",
    image = "https://cdn1.epicgames.com/offer/e97659b501af4e3981d5430dad170911/EGS_HogwartsLegacy_AvalancheSoftware_S1_2560x1440-2baf3188eb3c1aa248bcc1af6a927b7e",
    priceHistory = null,
    currentPrice = 249.99f
)