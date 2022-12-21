package me.brisson.steam_copy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.steam_copy.R
import me.brisson.steam_copy.domain.model.Game
import me.brisson.steam_copy.domain.model.finalFantasyGame
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.presentation.ui.theme.montserrat
import kotlin.math.roundToInt

@Composable
fun GameTile(
    modifier: Modifier = Modifier,
    game: Game,
    onClick: () -> Unit
) {
    val tileWidth = (LocalConfiguration.current.screenWidthDp.dp) * 0.80f

    Column(modifier = modifier.width(tileWidth).clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(game.image)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.person_placeholder)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF0d1721), Color(0xFF1f3653))
                    )
                )
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = game.name,
                maxLines = 1,
                style = TextStyle(
                    fontFamily = montserrat,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                ),
                overflow = TextOverflow.Ellipsis
            )

            GamePriceComponent(game = game)

        }
    }
}

@Composable
fun GameTileBig(
    modifier: Modifier = Modifier,
    game: Game,
    onClick: () -> Unit
) {
    val tileWidth = (LocalConfiguration.current.screenWidthDp.dp) * 0.73f

    Column(modifier = modifier.width(tileWidth).clickable { onClick() }) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(game.image)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.person_placeholder)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF1b5978), Color(0xFF317b97))
                    )
                )
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(
                    text = game.name,
                    maxLines = 1,
                    style = TextStyle(
                        fontFamily = montserrat,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    ),
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(top = 1.dp),
                    text = "Oferta válida até 5/jan./2023 às 15:00",
                    style = TextStyle(
                        fontFamily = montserrat,
                        color = Color(0xFFa5e5ff),
                        fontSize = 10.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }


            game.currentPrice?.let { currentPrice ->
                game.priceHistory?.first()?.let { odlPrice ->
                    GamePromoBigComponent(
                        currentPrice = currentPrice,
                        oldPrice = odlPrice
                    )
                }
            }

        }
    }


}

@Composable
private fun GamePriceComponent(modifier: Modifier = Modifier, game: Game) {
    val gamePromo = game.currentPrice != null && !game.priceHistory.isNullOrEmpty()
    val normalPrice = game.currentPrice != null && game.priceHistory.isNullOrEmpty()
    val freeToPlay = game.currentPrice == null

    val textStyle = TextStyle(
        fontFamily = montserrat,
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 12.sp
    )

    when {
        freeToPlay -> {
            Text(modifier = modifier, text = "Gratiuto p/ Jogar", style = textStyle)
        }
        normalPrice -> {
            game.currentPrice?.let { Text(modifier = modifier, text = "R$ $it", style = textStyle) }
        }
        gamePromo -> {
            game.currentPrice?.let { currentPrice ->
                game.priceHistory?.first()?.let { oldPrice ->
                    GamePromoComponent(
                        modifier = modifier,
                        currentPrice = currentPrice,
                        oldPrice = oldPrice
                    )
                }
            }
        }
    }
}

@Composable
private fun GamePromoComponent(
    modifier: Modifier = Modifier,
    currentPrice: Float,
    oldPrice: Float
) {
    val discountPercentage = ((currentPrice.times(100f)) / oldPrice).roundToInt()

    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier
                .background(color = Color(0xFF4b6b21))
                .padding(horizontal = 3.dp, vertical = 0.dp),
            text = "-$discountPercentage%",
            color = Color(0xFFbde842)
        )
        Row(
            modifier = Modifier
                .background(color = Color(0xFF344654))
                .fillMaxHeight()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "R$ $oldPrice",
                fontSize = 11.sp,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "R$ $currentPrice",
                fontSize = 11.sp,
                color = Color(0xFFbde842),
            )
        }
    }
}

@Composable
fun GamePromoBigComponent(
    modifier: Modifier = Modifier,
    currentPrice: Float,
    oldPrice: Float
) {
    val discountPercentage = ((currentPrice.times(100f)) / oldPrice).roundToInt()

    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color(0xFF4b6b21))
                .padding(horizontal = 3.dp, vertical = 0.dp),
            text = "-$discountPercentage%",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFbde842)
        )
        Column(
            modifier = Modifier
                .background(color = Color(0xFF344654))
                .padding(horizontal = 4.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "R$ $oldPrice",
                fontSize = 10.sp,
                color = Color.Gray,
                textDecoration = TextDecoration.LineThrough
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = "R$ $currentPrice",
                fontSize = 11.sp,
                color = Color(0xFFbde842),
            )
        }
    }
}

@Preview
@Composable
fun PreviewGameTile() {
    SteamCopyTheme {
        Box(Modifier.fillMaxWidth()) {
            GameTile(game = finalFantasyGame, onClick = { })
        }
    }
}

@Preview
@Composable
fun PreviewGameTileBig() {
    SteamCopyTheme {
        Box(Modifier.fillMaxWidth()) {
            GameTileBig(game = finalFantasyGame, onClick = { })
        }
    }
}