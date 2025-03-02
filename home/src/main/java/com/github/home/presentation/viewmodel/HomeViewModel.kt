package com.github.home.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.common.utility.base.BaseViewModel
import com.github.home.domain.model.User
import com.github.home.domain.usecase.GetGitHubUserDetailUseCase
import com.github.home.domain.usecase.GetGitHubUsersUseCase
import com.github.home.presentation.mvi.effect.HomeEffect
import com.github.home.presentation.mvi.event.HomeEvent
import com.github.home.presentation.mvi.reducer.HomeScreenReducer
import com.github.home.presentation.mvi.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGitHubUsersUseCase: GetGitHubUsersUseCase,
    private val getGitHubUserDetailUseCase: GetGitHubUserDetailUseCase
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>(
    initialState = HomeState.initial(),
    reducer = HomeScreenReducer()
) {
    init {
        viewModelScope.launch {
            getGitHubUsersUseCase.refreshUsers()
            sendEvent(HomeEvent.HomeListLoading(true))
            getGitHubUsersUseCase.getUsersFlow()
                .collectLatest { userList ->
                    sendEvent(HomeEvent.HomeListLoading(false))
                    sendEvent(HomeEvent.HomeUserList(userList))
                }
        }
    }

    fun onUserClick(user: User) {
        sendEffect(effect = HomeEffect.NavigateToDetail(user = user))
    }
}