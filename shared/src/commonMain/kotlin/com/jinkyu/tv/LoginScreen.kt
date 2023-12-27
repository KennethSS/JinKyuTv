package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.ui.AppNameLabel
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.JinKyuButton
import com.jinkyu.tv.ui.JinKyuTextField
import com.jinkyu.tv.ui.LoginLabel
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.RegisterLabel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = LoginViewModel() //koinInject<MainViewModel>()

    val email by rememberSaveable { derivedStateOf { viewModel.email.value } }
    val password by rememberSaveable { derivedStateOf { viewModel.password.value } }
    val loginEnable by rememberSaveable { derivedStateOf { viewModel.loginEnable.value } }

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Divider(height = 20)
        Text(
            text = AppNameLabel,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Divider(height = 24)
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
            buttonLabel = LoginLabel,
            enable = loginEnable,
            onClicked = { viewModel.onLoginClicked() }
        )
        Divider(height = 12)
        JinKyuButton(
            buttonLabel = RegisterLabel,
            enable = true,
            onClicked = { viewModel.onCreateUserClicked() }
        )
    }
}
