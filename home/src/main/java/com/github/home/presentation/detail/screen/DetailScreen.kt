package com.github.home.presentation.detail.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.common.utility.extenstion.rememberFlowWithLifecycle
import com.github.home.domain.model.UserDetail
import com.github.home.presentation.detail.mvi.effect.DetailEffect
import com.github.home.presentation.detail.screen.components.StatItem
import com.github.home.presentation.detail.viewmodel.DetailViewModel

/**
 * Composable function to display user details screen.
 *
 * @param userName The username of the GitHub user.
 * @param modifier Modifier for styling the screen.
 * @param detailViewModel ViewModel managing user details.
 * @param navHostController Navigation controller for handling back navigation.
 */
@Composable
fun DetailScreen(
    userName: String,
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val state by detailViewModel.state.collectAsStateWithLifecycle()
    val effect = rememberFlowWithLifecycle(detailViewModel.effect, LocalLifecycleOwner.current)

    LaunchedEffect(userName) {
        detailViewModel.loadUserDetail(userName)
    }

    LaunchedEffect(effect) {
        effect.collect { action ->
            if (action is DetailEffect.NavigateToHome) {
                navHostController.popBackStack()
            }
        }
    }

    DetailScreenContent(
        modifier = modifier,
        onBack = { detailViewModel.sendEffect(DetailEffect.NavigateToHome) },
        isLoading = state.loading,
        userDetail = state.userDetail
    )
}

/**
 * Displays the user details content.
 *
 * @param modifier Modifier for styling.
 * @param onBack Callback to handle back navigation.
 * @param isLoading Whether data is loading.
 * @param userDetail The user details to be displayed.
 */
@Composable
fun DetailScreenContent(
    modifier: Modifier,
    onBack: () -> Unit,
    isLoading: Boolean,
    userDetail: UserDetail?
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = com.github.common.R.drawable.ic_back_button),
                        contentDescription = "Back",
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }

        if (isLoading) {
            item { CircularProgressIndicator() }
        }

        userDetail?.let { detail ->
            item {
                Text(
                    "@${detail.username}", fontSize = 22.sp, fontWeight = FontWeight.Bold
                )
            }

            item {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(detail.avatarUrl)
                        .crossfade(true).build(),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )
            }

            detail.name?.let { name ->
                item { Text(name, fontSize = 18.sp, color = Color.Gray) }
            }

            detail.bio?.let { bio ->
                item { Text(bio, fontSize = 16.sp, color = Color.DarkGray) }
            }

            detail.company?.let { company ->
                item { Text("Company: $company", fontSize = 16.sp) }
            }

            detail.blog?.let { blog ->
                item { Text("Blog: $blog", fontSize = 16.sp, color = Color.Blue) }
            }

            detail.location?.let { location ->
                item { Text("Location: $location", fontSize = 16.sp) }
            }

            detail.twitterUsername?.let { twitter ->
                item { Text("Twitter: @$twitter", fontSize = 16.sp, color = Color.Blue) }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem("Repos", detail.publicRepos)
                    StatItem("Gists", detail.publicGists)
                    StatItem("Followers", detail.followers)
                    StatItem("Following", detail.following)
                }
            }

            item { Text("Joined: ${detail.createdAt}", fontSize = 14.sp, color = Color.Gray) }
            item { Text("Last Updated: ${detail.updatedAt}", fontSize = 14.sp, color = Color.Gray) }
        }
    }
}

