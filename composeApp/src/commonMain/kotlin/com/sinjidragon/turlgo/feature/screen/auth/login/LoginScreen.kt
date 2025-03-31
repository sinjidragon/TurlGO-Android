package com.sinjidragon.turlgo.feature.screen.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sinjidragon.turlgo.feature.screen.auth.login.model.LoginPendingUiState
import com.sinjidragon.turlgo.feature.screen.auth.login.viewModel.LoginViewModel
import com.sinjidragon.turlgo.feature.screen.auth.signUp.model.SignUpPendingUiState
import com.sinjidragon.turlgo.resource.color.AppColors
import com.sinjidragon.turlgo.resource.component.botton.CircleButton
import com.sinjidragon.turlgo.resource.component.textfield.AuthTextField
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.back
import turlgo.composeapp.generated.resources.password
import turlgo.composeapp.generated.resources.person
import turlgo.composeapp.generated.resources.turlgologo

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit,
    popBackStack: () -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val interaction = remember { MutableInteractionSource() }
    val state by viewModel.state.collectAsState()
    var token by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    val idFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }

    when (state.loginUiState) {
        is LoginPendingUiState.Success -> {
            token = state.token.accessToken.toString()
            println(token)
            navigateToHome()
        }

        is LoginPendingUiState.Error -> {
            error = (state.loginUiState as LoginPendingUiState.Error).error.toString()
        }

        else -> {}
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 42.dp)
    ) {
        Row(
            modifier = modifier
                .clickable(
                    interactionSource = interaction,
                    indication = null
                ) {
                    popBackStack()
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.back),
                contentDescription = null
            )
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = "뒤로가기",
                color = AppColors.bottom_gray,
                fontSize = 16.sp
            )
        }
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = modifier.height(67.dp))
            Image(
                painter = painterResource(Res.drawable.turlgologo),
                contentDescription = null
            )
            Spacer(modifier = modifier.height(12.dp))
            Text(
                text = "로그인",
                fontSize = 16.sp
            )
        }
        Column(
            modifier = modifier
                .padding(horizontal = 30.dp)
                .padding(top = 100.dp)
                .padding(bottom = 100.dp)
                .align(alignment = Alignment.Center)
        ) {
            AuthTextField(
                isPassword = false,
                value = text,
                onValueChange = { text = it },
                isError = error.isNotEmpty(),
                error = error,
                hint = "아이디를 입력해주세요",
                painter = painterResource(Res.drawable.person),
                title = "아이디",
                focusRequester = idFocusRequester,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { passwordFocusRequester.requestFocus() }
                )
            )
            Spacer(modifier = modifier.height(10.dp))
            AuthTextField(
                isPassword = true,
                value = password,
                onValueChange = { password = it },
                isError = false,
                error = "",
                painter = painterResource(Res.drawable.password),
                title = "비밀번호",
                hint = "비밀번호를 입력해주세요",
                focusRequester = passwordFocusRequester,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )
        }
        Column(
            modifier = modifier
                .padding(bottom = 28.dp)
                .padding(horizontal = 50.dp)
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleButton(
                onClick = {
                    viewModel.login(text, password)
                },
                text = "로그인"
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = "계정이 없다면? 회원가입",
                color = AppColors.text_dark_gray,
                fontSize = 14.sp,
                modifier = modifier
                    .clickable(
                        interactionSource = interaction,
                        indication = null
                    ) {
                        navigateToSignUp()
                    },
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}

