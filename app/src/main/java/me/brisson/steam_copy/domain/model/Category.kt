package me.brisson.steam_copy.domain.model

import androidx.compose.ui.graphics.Color
import me.brisson.steam_copy.utils.random

data class Category(
    val name: String,
    val image: String,
    val color: Color = Color.random()
)

val fictionCategory = Category(
    name = "FICÇÃO CIENTÍFICA E CYBERPUNK",
    image = "https://store.steampowered.com/categories/homepageimage/category/science_fiction?cc=us&l=english"
)

val freeToPlayCategory = Category(
    name = "GRATUITOS PARA JOGAR",
    image = "https://store.steampowered.com/categories/homepageimage/freetoplay?cc=us&l=english"
)

val actionCategory = Category(
    name = "AÇÃO",
    image = "https://store.steampowered.com/categories/homepageimage/category/action?cc=us&l=english"
)

val survivalCategory = Category(
    name = "SOBREVIVÊCIA",
    image = "https://store.steampowered.com/categories/homepageimage/category/survival?cc=us&l=english"
)

val casualCategory = Category(
    name = "CASUAL",
    image = "https://store.steampowered.com/categories/homepageimage/category/casual?cc=us&l=english"
)

val roguelikeCategory = Category(
    name = "ROUGUELIKE",
    image = "https://store.steampowered.com/categories/homepageimage/category/rogue_like_rogue_lite?cc=us&l=english"
)

val simulationCategory = Category(
    name = "SIMULAÇÃO",
    image = "https://store.steampowered.com/categories/homepageimage/category/simulation?cc=us&l=english"
)