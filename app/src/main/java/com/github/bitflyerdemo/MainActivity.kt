package com.github.bitflyerdemo


import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.github.bitflyerdemo.navigation.AppNavGraph
import com.github.common.ui.theme.GitHubTheme
import com.github.common.utility.extenstion.isInternetAvailable
import dagger.hilt.android.AndroidEntryPoint

/**
 * MainActivity serves as the entry point of the application.
 *
 * It initializes the UI, applies the app theme, and sets up navigation.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isInternetAvailable(this).not()) {
            Toast.makeText(this, "Internet is required :)", Toast.LENGTH_SHORT).show()
        }
        // Allows content to extend into system bars for a modern look
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge() // Ensures edge-to-edge layout

        setContent {
            GitHubTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavGraph(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
