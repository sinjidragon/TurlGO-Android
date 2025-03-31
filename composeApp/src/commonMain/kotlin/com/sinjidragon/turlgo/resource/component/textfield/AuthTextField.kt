package com.sinjidragon.turlgo.resource.component.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.turlgo.resource.color.AppColors
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.password_eye
import turlgo.composeapp.generated.resources.password_not
import turlgo.composeapp.generated.resources.reddots

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    error: String,
    title: String,
    painter: Painter,
    hint: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    focusRequester: FocusRequester
) {
    var show by remember {
        mutableStateOf(!isPassword)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            color = AppColors.placeholder_gray
        )
        Spacer(modifier = modifier.height(4.dp))
        Column {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .border(
                        width = 1.dp,
                        color = AppColors.border_gray,
                        shape = RoundedCornerShape(size = 12.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 10.dp),
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null
                    )
                    Spacer(modifier = modifier.width(4.dp))
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        textStyle = TextStyle(fontSize = 14.sp),
                        decorationBox = { innerTextField ->
                            if (value.isEmpty()) {
                                Text(
                                    text = hint,
                                    color = AppColors.placeholder_gray,
                                    fontSize = 14.sp
                                )
                            }
                            innerTextField()
                        },
                        singleLine = true,
                        visualTransformation = if (show) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = keyboardOptions,
                        keyboardActions = keyboardActions,
                        modifier = Modifier
                            .weight(1f)
                            .focusRequester(focusRequester)
                    )
                }
                if (isPassword) {
                    Image(
                        painter = painterResource(if (show) Res.drawable.password_not else Res.drawable.password_eye),
                        contentDescription = null,
                        modifier = modifier
                            .clickable {
                                show = !show
                                println(show)
                            }
                            .align(alignment = Alignment.CenterEnd)
                    )
                }
            }
            Spacer(modifier = modifier.height(12.dp))
            AnimatedVisibility(isError) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(Res.drawable.reddots),
                        contentDescription = null,
                        modifier = modifier
                            .size(4.dp)
                    )
                    Spacer(modifier = modifier.width(6.dp))
                    Text(
                        text = error,
                        color = AppColors.text_error
                    )
                }
            }
        }
    }
}