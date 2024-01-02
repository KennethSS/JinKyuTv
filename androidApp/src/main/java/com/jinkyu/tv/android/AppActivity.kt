package com.jinkyu.tv.android

import android.app.PictureInPictureParams
import android.os.Bundle
import android.util.Rational
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jinkyu.tv.navigation.AppNavHost

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                AppNavHost()
            }
        }
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        val aspectRatio = Rational(16, 9)

        val params =
            PictureInPictureParams
                .Builder()
                .setAspectRatio(aspectRatio)
                .build()

        enterPictureInPictureMode(params)
    }
}