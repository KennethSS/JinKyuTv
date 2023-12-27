package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.presentation.RegisterViewModel
import com.jinkyu.tv.ui.AppNameLabel
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.NicknameLabel
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.RegisterLabel
import com.jinkyu.tv.ui.SpacerWeight
import com.jinkyu.tv.ui.system.Button
import com.jinkyu.tv.ui.system.JinKyuTextField
import com.jinkyu.tv.ui.system.JinKyuTopBar

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {
    val nickName by viewModel.nickName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val registerEnable by viewModel.registerEnable.collectAsState()

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        JinKyuTopBar(
            label = RegisterLabel,
            onBackButtonClicked = { viewModel.onBackButtonClicked() }
        )
        SpacerWeight()
        Text(
            text = AppNameLabel,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Divider(height = 24)
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
        Button(
            buttonLabel = RegisterLabel,
            enable = registerEnable,
            onClicked = { viewModel.onCreateUserClicked() }
        )
        Divider(height = 48)
        SpacerWeight()
    }
}
