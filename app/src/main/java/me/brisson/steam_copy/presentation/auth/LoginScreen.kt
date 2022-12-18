package me.brisson.steam_copy.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.presentation.ui.theme.montserrat

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onAuthenticated: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "SIGN IN",
            style = TextStyle(fontSize = 26.sp, color = MaterialTheme.colorScheme.onBackground)
        )
        CustomInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
            onTextChange = { },
            label = {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "STEAM ACCOUNT NAME",
                    style = TextStyle(fontFamily = montserrat, color = Color.White)
                )
            }
        )
        CustomInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            onTextChange = { },
            isPassword = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            label = {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "PASSWORD",
                    style = TextStyle(fontFamily = montserrat, color = Color.White)
                )
            }
        )
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            onClick = onAuthenticated
        ) {
            Text(text = "Sign in", style = TextStyle(fontSize = 18.sp))
        }
        TextButton(
            modifier = Modifier.padding(top = 40.dp),
            onClick = { }
        ) {
            Text(
                text = "Forgot your account name or password?",
                style = TextStyle(
                    fontFamily = montserrat,
                    color = MaterialTheme.colorScheme.onBackground
                ),
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    SteamCopyTheme {
        LoginScreen(onAuthenticated = { })
    }
}