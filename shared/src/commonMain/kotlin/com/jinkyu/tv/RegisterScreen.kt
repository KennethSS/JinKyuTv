package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.presentation.RegisterViewModel
import com.jinkyu.tv.ui.AlreadyHaveAccount
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.EmailHint
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.LoginLabel
import com.jinkyu.tv.ui.NicknameHint
import com.jinkyu.tv.ui.NicknameLabel
import com.jinkyu.tv.ui.PasswordHint
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.SignUpLabel
import com.jinkyu.tv.ui.SignUpMessage1
import com.jinkyu.tv.ui.SignUpMessage2
import com.jinkyu.tv.ui.SpacerWeight
import com.jinkyu.tv.ui.system.AlreadyTextButton
import com.jinkyu.tv.ui.system.AppLogoLabel
import com.jinkyu.tv.ui.system.Button
import com.jinkyu.tv.ui.system.JinKyuPasswordTextField
import com.jinkyu.tv.ui.system.JinKyuTextField
import com.jinkyu.tv.ui.system.JinKyuTopBar
import com.jinkyu.tv.ui.system.Label
import com.jinkyu.tv.ui.system.WelcomeLabel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {
    val nickName by viewModel.nickName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val registerEnable by viewModel.registerEnable.collectAsState()

    Scaffold(
        modifier = modifier.background(Color.White),
        topBar = {
            JinKyuTopBar(
                label = SignUpLabel,
                onBackButtonClicked = { viewModel.onBackButtonClicked() }
            )
        }
    ) {
        Column(
            modifier = modifier.background(Color.White).padding(it).padding(horizontal = 26.dp)
        ) {
            AppLogoLabel(true)
            WelcomeLabel(
                firstLabel = SignUpMessage1,
                secondLabel = SignUpMessage2
            )
            Label(label = NicknameLabel)
            JinKyuTextField(
                modifier = Modifier.fillMaxWidth(),
                text = nickName,
                onValueChange = { viewModel.onUserInput(type = UserInput.NICKNAME, input = it) },
                hint = NicknameHint
            )
            Label(label = EmailLabel)
            JinKyuTextField(
                modifier = Modifier.fillMaxWidth(),
                text = email,
                onValueChange = { viewModel.onUserInput(type = UserInput.EMAIL, input = it) },
                hint = EmailHint
            )
            Label(label = PasswordLabel)
            JinKyuPasswordTextField(
                modifier = Modifier.fillMaxWidth(),
                text = password,
                onValueChange = { viewModel.onUserInput(type = UserInput.PASSWORD, input = it) },
                hint = PasswordHint
            )
            SpacerWeight()
            Button(
                buttonLabel = SignUpLabel,
                enable = registerEnable,
                onClicked = { viewModel.onRegisterClicked() }
            )
            AlreadyTextButton(
                message = AlreadyHaveAccount,
                buttonLabel = LoginLabel,
                onButtonClicked = {}
            )
            Divider(height = 38)
        }
    }
}
