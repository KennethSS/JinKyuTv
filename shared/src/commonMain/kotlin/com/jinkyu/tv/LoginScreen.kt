package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.presentation.MainViewModel
import com.jinkyu.tv.ui.JinKyuButton
import com.jinkyu.tv.ui.JinKyuTextField

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    val mainViewModel = MainViewModel() //koinInject<MainViewModel>()

    var id by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val loginEnable by remember {
        derivedStateOf { id.isNotBlank() && password.isNotBlank() }
    }

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))
        Text(
            text = "JinKyu Tv",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = id,
            onValueChange = { id = it },
            label = "아이디"
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onValueChange = { password = it },
            label = "비밀번호"
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))
        JinKyuButton(
            buttonLabel = "로그인",
            enable = loginEnable,
            onClicked = { mainViewModel.onLoginClicked() }
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))
        JinKyuButton(
            buttonLabel = "회원가입",
            enable = true,
            onClicked = { mainViewModel.onNavigateToRegisterClicked() }
        )
    }
}
