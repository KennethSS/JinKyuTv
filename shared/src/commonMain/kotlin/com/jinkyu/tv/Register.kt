package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.presentation.MainViewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
) {

    val mainViewModel = MainViewModel() //koinInject<MainViewModel>()

    var id by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var nickName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val registerEnable by remember {
        derivedStateOf { id.isNotBlank() && email.isNotBlank() && nickName.isNotBlank() && password.isNotBlank() }
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
            text = nickName,
            onValueChange = { nickName = it },
            label = "닉네임"
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = id,
            onValueChange = { id = it },
            label = "아이디"
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = email,
            onValueChange = { email = it },
            label = "이메일"
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onValueChange = { password = it },
            label = "비밀번호"
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(12.dp))
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .clip(shape = RoundedCornerShape(12.dp))
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .background(if (registerEnable) Color.Blue else Color.LightGray)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .clickable { if (registerEnable) mainViewModel.onRegisterClicked() }
                    .padding(vertical = 12.dp, horizontal = 24.dp),
                text = "회원가입",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if (registerEnable) Color.White else Color.Black
            )
        }
    }
}

@Composable
fun JinKyuTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    label: String
) {
   Column(
       modifier = modifier
   ) {
       Spacer(modifier = modifier.height(12.dp))
       TextField(
           modifier = modifier,
           value = text,
           onValueChange = onValueChange,
           label = { Text(label) }
       )
   }
}
