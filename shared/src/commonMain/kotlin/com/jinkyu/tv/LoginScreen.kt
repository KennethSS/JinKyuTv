package com.jinkyu.tv

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import com.jinkyu.tv.presentation.LoginViewModel
import com.jinkyu.tv.ui.Divider
import com.jinkyu.tv.ui.DividerWeight
import com.jinkyu.tv.ui.EmailHint
import com.jinkyu.tv.ui.EmailLabel
import com.jinkyu.tv.ui.ForgotPasswordLabel
import com.jinkyu.tv.ui.HaveNotAccount
import com.jinkyu.tv.ui.LoginLabel
import com.jinkyu.tv.ui.LoginMessage1
import com.jinkyu.tv.ui.LoginMessage2
import com.jinkyu.tv.ui.PasswordHint
import com.jinkyu.tv.ui.PasswordLabel
import com.jinkyu.tv.ui.RememberMeLabel
import com.jinkyu.tv.ui.SignUpLabel
import com.jinkyu.tv.ui.SocialLoginButtons
import com.jinkyu.tv.ui.SocialLoginDivider
import com.jinkyu.tv.ui.system.AlreadyTextButton
import com.jinkyu.tv.ui.system.AppLogoLabel
import com.jinkyu.tv.ui.system.Button
import com.jinkyu.tv.ui.system.ColorBlue
import com.jinkyu.tv.ui.system.ColorRed
import com.jinkyu.tv.ui.system.JinKyuPasswordTextField
import com.jinkyu.tv.ui.system.JinKyuTextField
import com.jinkyu.tv.ui.system.Label
import com.jinkyu.tv.ui.system.WelcomeLabel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginEnable by viewModel.loginEnable.collectAsState()
    val rememberMe by viewModel.rememberMe.collectAsState()

    Column(
        modifier = modifier.background(Color.White).padding(horizontal = 26.dp)
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { viewModel.onRememberMeClicked(it) },
                    colors = CheckboxDefaults.colors(checkedColor = ColorBlue)
                )
            }
            Divider(width = 8)
            Text(
                text = RememberMeLabel,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                color = ColorBlue,
            )
            DividerWeight()
            Text(
                modifier = Modifier.clickable { viewModel.onSignUpClicked() },
                text = ForgotPasswordLabel,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold,
                color = ColorRed,
            )
        }
        DividerWeight()
        Button(
            buttonLabel = LoginLabel,
            enable = loginEnable,
            onClicked = { viewModel.onLoginClicked() }
        )
        SocialLoginDivider()
        SocialLoginButtons(
            onGitHubButtonClicked = { viewModel.onSignUpClicked() },
            onGitLabButtonClicked = { viewModel.onSignUpClicked() }
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
