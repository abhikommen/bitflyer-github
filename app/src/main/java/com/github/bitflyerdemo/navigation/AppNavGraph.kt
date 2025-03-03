package com.github.bitflyerdemo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.toRoute
import com.github.home.presentation.detail.screen.DetailScreen
import com.github.home.presentation.home.screen.HomeScreen

/**
 * Manages the navigation graph for the application.
 *
 * This function initializes the NavController and sets up navigation routes
 * using the Jetpack Compose Navigation component.
 *
 * @param modifier Optional modifier for customization.
 */
@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home
    ) {
        // Home Screen Route
        composable<Home> {
            HomeScreen(navigateToDetail = { userName ->
                navController.navigate(Detail(userName = userName))
            })
        }

        // Detail Screen Route
        composable<Detail> { backStackEntry ->
            val detail: Detail = backStackEntry.toRoute()
            DetailScreen(
                userName = detail.userName, navHostController = navController
            )
        }
    }
}

/**
 * Preview function to visualize the AppNavGraph in isolation.
 */
@Preview(showBackground = true)
@Composable
fun PreviewAppNavGraph() {
    AppNavGraph()
}
