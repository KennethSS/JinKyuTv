package com.jinkyu.tv

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import androidx.compose.ui.window.ComposeUIViewController
import com.jinkyu.tv.presentation.login.LoginScreen
import com.jinkyu.tv.presentation.player.PlayerViewModel
import com.jinkyu.tv.presentation.register.RegisterScreen
import com.jinkyu.tv.presentation.splash.SplashScreen
import com.jinkyu.tv.presentation.videos.VideoScreen
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import platform.AVFAudio.AVAudioSession
import platform.AVFAudio.AVAudioSessionCategory
import platform.AVFAudio.AVAudioSessionCategoryOptions
import platform.AVFAudio.AVAudioSessionMode
import platform.UIKit.UIViewController

fun SplashViewController(
    navigateMain: () -> Unit,
    navigateLogin: () -> Unit
): UIViewController {
    return ComposeUIViewController {
        SplashScreen(
            navigateMain = navigateMain,
            navigateLogin = navigateLogin,
        )
    }
}

fun LoginViewController(
    navigateRegister: () -> Unit,
    navigateMain: () -> Unit,
): UIViewController {
    return ComposeUIViewController {
        LoginScreen(
            navigateRegister = navigateRegister,
            navigateMain = navigateMain
        )
    }
}

fun RegisterViewController(
    navigateLogin: () -> Unit,
    navigateMain: () -> Unit,
): UIViewController {
    return ComposeUIViewController {
        RegisterScreen(
            navigateLogin = navigateLogin,
            navigateMain = navigateMain
        )
    }
}

fun VideoViewController(
    navigateMain: (String) -> Unit,
): UIViewController {
    return ComposeUIViewController {
        VideoScreen(
            navigateMain = navigateMain
        )
    }
}

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(): UIViewController {

    //val playerViewModel: PlayerViewModel by koinInject<PlayerViewModel>()

    val playerViewModel = KoinHelper().playerViewModel()
    val playerDelegate: ComposeUIViewControllerDelegate = object : ComposeUIViewControllerDelegate {
        override fun viewDidAppear(animated: Boolean) {
            super.viewDidAppear(animated)
            println("viewDidAppear")
            //playerViewModel.play()
            AVAudioSession.sharedInstance().setCategory(
                category = "AVAudioSessionCategoryPlayback",
                error = null
            )

            //playback AVAudioSessionCategory(_rawValue: AVAudioSessionCategoryPlayback)
        }

        override fun viewDidDisappear(animated: Boolean) {
            super.viewDidDisappear(animated)
            //playerViewModel.pause()
        }


        override fun viewDidLoad() {
            super.viewDidLoad()

        }
    }

    return ComposeUIViewController(
        configure = {
            delegate = playerDelegate
        },
        content = {
            MainScreen()
        }
    )
}

suspend fun asyncFunctionExample() = coroutineScope {
    delay(1000L)
}