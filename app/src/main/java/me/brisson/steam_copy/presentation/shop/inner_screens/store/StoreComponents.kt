package me.brisson.steam_copy.presentation.shop.inner_screens.store

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.presentation.ui.theme.montserrat

@Composable
fun SegmentTitle(
    modifier: Modifier = Modifier,
    title: String,
    onMore: (() -> Unit)? = null
) {
    Row(
        modifier = modifier.padding(start = 20.dp, bottom = 10.dp, end = 10.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = title,
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp,
                fontFamily = montserrat
            )
        )

        onMore?.let {
            val contentColor = Color.Gray
            Row(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .clickable { it() }
                    .padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ver mais",
                    style = TextStyle(
                        color = contentColor,
                        fontSize = 12.sp,
                        fontFamily = montserrat
                    )
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 5.dp).size(10.dp),
                    tint = contentColor
                )
            }
        }
    }
}

@Preview()
@Composable
fun PreviewSegmentTitle() {
    SteamCopyTheme {
        Box(Modifier.fillMaxWidth()) {
            SegmentTitle(title = "OFERTAS ESPECIAIS", onMore = { })
        }
    }
}