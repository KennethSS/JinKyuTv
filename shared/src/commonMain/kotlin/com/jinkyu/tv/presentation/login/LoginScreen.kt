package com.jinkyu.tv.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jinkyu.tv.domain.user.UserInput
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.DividerWeight
import com.jinkyu.tv.ui.EmailHint
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.HaveNotAccount
import com.jinkyu.tv.ui.LoginMessage1
import com.jinkyu.tv.ui.LoginMessage2
import com.jinkyu.tv.ui.PasswordHint
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.SignUpLabel
import com.jinkyu.tv.ui.SocialLoginButtons
import com.jinkyu.tv.ui.SocialLoginDivider
import com.jinkyu.tv.ui.system.AlreadyTextButton
import com.jinkyu.tv.ui.system.AppLogoLabel
import com.jinkyu.tv.ui.system.Button
import com.jinkyu.tv.ui.system.JinKyuPasswordTextField
import com.jinkyu.tv.ui.system.JinKyuTextField
import com.jinkyu.tv.ui.system.Label
import com.jinkyu.tv.ui.system.RememberCheckBox
import com.jinkyu.tv.ui.system.WelcomeLabel
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.koinInject

@Composable
fun LoginScreen(
    navigateRegister: () -> Unit,
    navigateMain: () -> Unit,
    viewModel: LoginViewModel = koinInject()
) {
    LaunchedEffect(Unit) {
        viewModel.navigationAction.collectLatest { navigation ->
            when (navigation) {
                LoginNavigationAction.NavigateToMain -> navigateMain()
                LoginNavigationAction.NavigateRegister -> navigateRegister()
            }
        }
    }

    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginEnable by viewModel.loginEnable.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()
    val loginLabel by viewModel.error.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(horizontal = 26.dp)
    ) {
        AppLogoLabel()
        WelcomeLabel(
            firstLabel = LoginMessage1,
            secondLabel = LoginMessage2
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
        Divider(height = 16)
        RememberCheckBox(
            rememberMe = rememberMe,
            onCheckBoxClicked = { viewModel.onRememberMeClicked(it) },
            onForgotPasswordClicked = { viewModel.onSignUpClicked() }
        )
        Divider(height = 80)
        DividerWeight()
        Button(
            buttonLabel = loginLabel,
            enable = loginEnable,
            onClicked = { viewModel.onLoginClicked() }
        )
        SocialLoginDivider()
        SocialLoginButtons(
            onGitHubButtonClicked = { },
            onGitLabButtonClicked = { }
        )
        DividerWeight()
        AlreadyTextButton(
            message = HaveNotAccount,
            buttonLabel = SignUpLabel,
            onButtonClicked = { viewModel.onSignUpClicked() }
        )
        Divider(height = 18)
    }
}
