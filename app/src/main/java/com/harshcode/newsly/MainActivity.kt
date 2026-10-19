package com.harshcode.newsly

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.harshcode.newsly.domain.usecases.AppEntryUseCases
import com.harshcode.newsly.presentation.onBoarding.OnBoardingScreen
import com.harshcode.newsly.ui.theme.NewslyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    private var keepSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(2000L.milliseconds)
            keepSplashScreen = false
        }
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect {
                Log.d("Test",  it.toString())
            }
        }
        enableEdgeToEdge()
        setContent {
            NewslyTheme {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        OnBoardingScreen()
                    }
                }
            }
    }
}