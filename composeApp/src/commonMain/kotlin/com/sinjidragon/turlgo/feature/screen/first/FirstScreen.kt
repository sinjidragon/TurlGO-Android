package com.sinjidragon.turlgo.feature.screen.first

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.turlgo.resource.color.AppColors
import com.sinjidragon.turlgo.resource.component.botton.CircleButton
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.maincat
import turlgo.composeapp.generated.resources.turlgologo

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    val interaction = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 42.dp)
    ) {
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
                text = "새로운 가족을 만나는 장소",
                fontSize = 16.sp
            )
        }
        Image(
            painter = painterResource(Res.drawable.maincat),
            contentDescription = null,
            modifier = modifier
                .size(326.dp)
                .align(alignment = Alignment.Center)
        )
        Column(
            modifier = modifier
                .padding(bottom = 28.dp)
                .padding(horizontal = 50.dp)
                .align(alignment = Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleButton(
                onClick = {
                    navigateToSignUp()
                },
                text = "회원가입"
            )
            Spacer(modifier = modifier.height(6.dp))
            Text(
                text = "기존 계정으로 로그인",
                color = AppColors.text_dark_gray,
                fontSize = 14.sp,
                modifier = modifier
                    .clickable(
                        interactionSource = interaction,
                        indication = null
                    ) {
                        navigateToLogin()
                    },
                textDecoration = TextDecoration.Underline
            )
        }
    }
}