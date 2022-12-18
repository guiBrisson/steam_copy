package me.brisson.steam_copy.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.steam_copy.presentation.ui.theme.SteamCopyTheme
import me.brisson.steam_copy.presentation.ui.theme.montserrat
import me.brisson.steam_copy.presentation.ui.theme.primaryColor
import me.brisson.steam_copy.presentation.ui.theme.surfaceColor

@Composable
fun CustomInputText(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    label: @Composable () -> Unit,
    onTextChange: (String) -> Unit
) {
    var input by remember { mutableStateOf(TextFieldValue("")) }
    val textStyle = TextStyle(
        fontFamily = montserrat,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )

    Column(modifier = modifier.fillMaxWidth()) {
        label()
        BasicTextField(
            modifier = Modifier.clip(shape = RoundedCornerShape(4.dp))
                .fillMaxWidth()
                .height(60.dp)
                .background(surfaceColor),
            value = input,
            onValueChange = {
                input = it
                onTextChange(it.text)
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            textStyle = textStyle,
            singleLine = true,
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                        innerTextField()
                    }
                }
            }
        )
    }
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        modifier = modifier.height(54.dp),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = primaryColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray
        ),
        content = content
    )
}

@Preview
@Composable
fun PreviewCustomInputText() {
    SteamCopyTheme {
        CustomInputText(
            label = {
                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = "STEAM ACCOUNT NAME",
                    style = TextStyle(fontFamily = montserrat, color = Color.White)
                )
            }, onTextChange = { }
        )
    }
}

@Preview
@Composable
fun PreviewCustomButton() {
    SteamCopyTheme {
        CustomButton(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), onClick = { }) {
            Text(text = "Sign in", style = TextStyle(fontSize = 18.sp))
        }
    }
}