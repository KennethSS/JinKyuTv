package com.jinkyu.tv

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun ChatViewController(): UIViewController = ComposeUIViewController {
    App("iOS")
}