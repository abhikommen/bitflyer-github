package com.github.home.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.common.utility.extenstion.rememberFlowWithLifecycle
import com.github.home.domain.model.User
import com.github.home.presentation.mvi.effect.HomeEffect
import com.github.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val effect = rememberFlowWithLifecycle(viewModel.effect, LocalLifecycleOwner.current)

    LaunchedEffect(effect) {
        effect.collect { action ->
            when (action) {
                is HomeEffect.NavigateToDetail -> {
                    // navigate to details..
                }
            }
        }
    }

    ForYouScreenContent(
        modifier = modifier,
        isLoading = state.value.loading,
        users = state.value.users,
        onUserClick = viewModel::onUserClick
    )
}

@Composable
fun ForYouScreenContent(
    modifier: Modifier,
    isLoading: Boolean,
    users: List<User>,
    onUserClick: (User) -> Unit
) {

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        Text("Hello")
        LazyColumn {
            items(users) { user ->
                Text("User: ${user.username}")
            }
        }
    }

}
