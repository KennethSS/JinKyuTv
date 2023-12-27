package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.presentation.RegisterViewModel
import com.jinkyu.tv.presentation.UserInput
import com.jinkyu.tv.ui.AppNameLabel
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.JinKyuButton
import com.jinkyu.tv.ui.JinKyuTextField
import com.jinkyu.tv.ui.JinKyuTopBar
import com.jinkyu.tv.ui.NicknameLabel
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.SpacerWeight

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = RegisterViewModel() //koinInject<MainViewModel>()

    val screenLabel = "회원가입"
    val email by rememberSaveable { derivedStateOf { viewModel.email.value } }
    val nickName by rememberSaveable { derivedStateOf { viewModel.nickName.value } }
    val password by rememberSaveable { derivedStateOf { viewModel.password.value } }

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        JinKyuTopBar(
            label = screenLabel,
            onBackButtonClicked = { viewModel.onBackButtonClicked() }
        )
        SpacerWeight()
        Text(
            text = AppNameLabel,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Divider(height = 12)
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = nickName,
            onValueChange = { viewModel.onUserInput(type = UserInput.NICKNAME, input = it) },
            label = NicknameLabel
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = email,
            onValueChange = { viewModel.onUserInput(type = UserInput.EMAIL, input = it) },
            label = EmailLabel
        )
        JinKyuTextField(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onValueChange = { viewModel.onUserInput(type = UserInput.PASSWORD, input = it) },
            label = PasswordLabel
        )
        Divider(height = 12)
        JinKyuButton(
            buttonLabel = screenLabel,
            enable = viewModel.registerEnable.value,
            onClicked = { viewModel.onCreateUserClicked() }
        )
        Divider(height = 48)
        SpacerWeight()
    }
}
