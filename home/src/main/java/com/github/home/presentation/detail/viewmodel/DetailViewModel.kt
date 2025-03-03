package com.github.home.presentation.detail.viewmodel

import androidx.lifecycle.viewModelScope
import com.github.common.utility.base.BaseViewModel
import com.github.home.domain.usecase.GetGitHubUserDetailUseCase
import com.github.home.presentation.detail.mvi.effect.DetailEffect
import com.github.home.presentation.detail.mvi.event.DetailEvent
import com.github.home.presentation.detail.mvi.reducer.DetailScreenReducer
import com.github.home.presentation.detail.mvi.state.DetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * ViewModel for managing the state and events of the Detail screen.
 *
 * This ViewModel follows the MVI (Model-View-Intent) pattern and handles fetching user details.
 *
 * @property getGitHubUserDetailUseCase Use case for fetching GitHub user details.
 */
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGitHubUserDetailUseCase: GetGitHubUserDetailUseCase
) : BaseViewModel<DetailState, DetailEvent, DetailEffect>(
    initialState = DetailState.initial(), reducer = DetailScreenReducer()
) {

    /**
     * Loads user details by triggering a network refresh and observing the database for updates.
     *
     * @param userName The GitHub username to fetch details for.
     */
    fun loadUserDetail(userName: String) {
        viewModelScope.launch {
            sendEvent(DetailEvent.DetailLoading(true))
            getGitHubUserDetailUseCase.refreshUserDetail(username = userName)
            getGitHubUserDetailUseCase.getUserFlow(username = userName)
                .collectLatest { userDetail ->
                    sendEvent(DetailEvent.DetailLoading(false))
                    userDetail?.let {
                        sendEvent(DetailEvent.DetailLoaded(userDetail = it))
                    }
                }
        }
    }
}
