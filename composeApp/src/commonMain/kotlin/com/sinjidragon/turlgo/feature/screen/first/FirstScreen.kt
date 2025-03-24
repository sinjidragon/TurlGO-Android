package com.sinjidragon.turlgo.feature.screen.first

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinjidragon.turlgo.App
import com.sinjidragon.turlgo.resource.color.AppColors
import com.sinjidragon.turlgo.resource.component.botton.MainButton
import org.jetbrains.compose.resources.painterResource
import turlgo.composeapp.generated.resources.Res
import turlgo.composeapp.generated.resources.maincat

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(Res.drawable.maincat),
            contentDescription = null,
            modifier = modifier
                .size(433.dp)
                .offset(x = 80.dp, y = (-100).dp)
                .align(alignment = Alignment.CenterEnd)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 70.dp)
                .offset(y = 180.dp)
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "털날리GO",
                color = AppColors.text_dark_gray,
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = "새로운 가족을 만나는 장소",
                color = AppColors.text_white_gray,
                fontSize = 14.sp,
            )
            Spacer(modifier = modifier.height(60.dp))
            MainButton(
                onClick = {},
                text = "회원가입"
            )
            Spacer(modifier = modifier.height(6.dp))
            Text(
                text = "이미 계정이 있다면? 로그인",
                color = AppColors.text_dark_gray,
                fontSize = 14.sp
            )
        }
    }
}