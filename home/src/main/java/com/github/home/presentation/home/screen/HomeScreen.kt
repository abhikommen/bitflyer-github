@file:OptIn(ExperimentalFoundationApi::class)

package com.github.home.presentation.home.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.common.component.HorizontalSpacer
import com.github.common.component.VerticalSpacer
import com.github.common.utility.extenstion.rememberFlowWithLifecycle
import com.github.home.domain.model.User
import com.github.home.presentation.home.mvi.effect.HomeEffect
import com.github.home.presentation.home.screen.component.UserCell
import com.github.home.presentation.home.viewmodel.HomeViewModel

/**
 * Composable function to display the Home screen.
 *
 * @param modifier Modifier for styling.
 * @param navigateToDetail Callback to navigate to the detail screen.
 * @param viewModel ViewModel for managing Home screen state.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val effect = rememberFlowWithLifecycle(viewModel.effect, LocalLifecycleOwner.current)

    LaunchedEffect(effect) {
        effect.collect { action ->
            if (action is HomeEffect.NavigateToDetail) {
                navigateToDetail(action.user.username)
            }
        }
    }

    HomeScreenContent(
        modifier = modifier,
        isLoading = state.loading,
        users = state.users,
        onUserClick = viewModel::onUserClick
    )
}

/**
 * Displays the content of the Home screen.
 *
 * @param modifier Modifier for styling.
 * @param isLoading Whether the user list is being loaded.
 * @param users List of users to display.
 * @param onUserClick Callback when a user is clicked.
 */
@Composable
fun HomeScreenContent(
    modifier: Modifier, isLoading: Boolean, users: List<User>, onUserClick: (User) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { VerticalSpacer(size = 120) }

            stickyHeader {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = com.github.common.R.drawable.ic_github),
                        contentDescription = "GitHub Users",
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    HorizontalSpacer()
                    Text(
                        text = "Users",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            if (isLoading) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            items(users) { user ->
                UserCell(user = user, onUserClick = onUserClick)
            }
        }
    }
}

