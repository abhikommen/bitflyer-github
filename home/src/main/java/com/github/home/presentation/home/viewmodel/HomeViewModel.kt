package com.github.home.presentation.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.common.utility.base.BaseViewModel
import com.github.home.domain.model.User
import com.github.home.domain.usecase.GetGitHubUsersUseCase
import com.github.home.presentation.detail.mvi.effect.DetailEffect
import com.github.home.presentation.detail.mvi.event.DetailEvent
import com.github.home.presentation.detail.mvi.reducer.DetailScreenReducer
import com.github.home.presentation.detail.mvi.state.DetailState
import com.github.home.presentation.home.mvi.effect.HomeEffect
import com.github.home.presentation.home.mvi.event.HomeEvent
import com.github.home.presentation.home.mvi.reducer.HomeScreenReducer
import com.github.home.presentation.home.mvi.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing the state and events of the Home screen.
 *
 * This ViewModel follows the MVI (Model-View-Intent) pattern and handles fetching user lists.
 *
 * @property getGitHubUsersUseCase Use case for fetching GitHub users.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGitHubUsersUseCase: GetGitHubUsersUseCase
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>(
    initialState = HomeState.initial(), reducer = HomeScreenReducer()
) {

    init {
        fetchUsers()
    }

    /**
     * Fetches users from the API and updates the state.
     */
    private fun fetchUsers() {
        viewModelScope.launch {
            sendEvent(HomeEvent.HomeListLoading(true))

            getGitHubUsersUseCase.refreshUsers()

            getGitHubUsersUseCase.getUsersFlow().collectLatest { userList ->
                sendEvent(HomeEvent.HomeListLoading(false))
                sendEvent(HomeEvent.HomeUserList(userList))
            }
        }
    }

    /**
     * Handles user click event and triggers navigation effect.
     *
     * @param user The selected user to navigate to the Detail screen.
     */
    fun onUserClick(user: User) {
        sendEffect(HomeEffect.NavigateToDetail(user))
    }
}
