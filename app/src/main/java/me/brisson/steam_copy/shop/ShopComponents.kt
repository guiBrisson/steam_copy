package me.brisson.steam_copy.shop

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.steam_copy.R
import me.brisson.steam_copy.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.ui.theme.montserrat

@ExperimentalAnimationApi
@Composable
fun ShopHeader(
    modifier: Modifier = Modifier,
    onSearchTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onMenu: () -> Unit,
    onStore: () -> Unit,
    onWishList: () -> Unit,
    onWallet: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(modifier = Modifier.padding(start = 10.dp), onClick = onMenu) {
                Icon(
                    imageVector = Icons.Rounded.Menu,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            SearchInput(
                modifier = Modifier.weight(1f),
                onTextChange = onSearchTextChange,
                onSearch = onSearch
            )

            AsyncImage(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(40.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://images.unsplash.com/photo-1615946027884-5b6623222bf4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.person_placeholder)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            item {
                Text(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { onStore() }
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = "LOJA",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = montserrat
                    )
                )
            }

            item {
                Text(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { onWishList() }
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = "LISTA DE DESEJOS",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = montserrat
                    )
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .clickable { onWallet() }
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "CARTEIRA",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = montserrat
                        )
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp),
                        text = "(R$ 4,67)",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = montserrat
                        )
                    )
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun SearchInput(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var isFocused by remember { mutableStateOf(false) }
    var input by remember { mutableStateOf(TextFieldValue("")) }
    val textStyle = TextStyle(
        fontFamily = montserrat,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )

    BasicTextField(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .height(40.dp)
            .background(MaterialTheme.colorScheme.background)
            .onFocusChanged { isFocused = it.isFocused },
        value = input,
        onValueChange = {
            input = it
            onTextChange(it.text)
        },
        singleLine = true,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            focusManager.clearFocus()
            input = TextFieldValue("")
            onSearch(input.text)
        }),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        decorationBox = { innerTextField ->
            Crossfade(targetState = isFocused) { scope ->
                Box(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth()
                            .padding(horizontal = 0.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (scope) {
                            Box(modifier = Modifier
                                .weight(1f)
                                .padding(start = 10.dp)) {
                                innerTextField()
                            }
                            IconButton(
                                onClick = {
                                    focusManager.clearFocus()
                                    input = TextFieldValue("")
                                }
                            ) {
                                Icon(
                                    modifier = Modifier,
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = null,
                                    tint = Color.LightGray
                                )
                            }
                        } else {
                            Icon(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                painter = painterResource(id = R.drawable.steam_logo_with_text),
                                contentDescription = null,
                                tint = Color.LightGray
                            )
                            Icon(
                                modifier = Modifier.padding(horizontal = 10.dp),
                                imageVector = Icons.Rounded.Search,
                                contentDescription = null,
                                tint = Color.LightGray
                            )
                        }
                    }

                }
            }
        }
    )
}

@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewHomeHeader() {
    SteamCopyTheme {
        ShopHeader(
            onSearchTextChange = { },
            onSearch = { },
            onMenu = { },
            onStore = { },
            onWishList = { },
            onWallet = { }
        )
    }
}