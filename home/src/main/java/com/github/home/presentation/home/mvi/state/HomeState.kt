package com.github.home.presentation.home.mvi.state

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import com.github.home.presentation.detail.mvi.state.DetailState
import javax.annotation.concurrent.Immutable

/**
 * Represents the UI state for the Home screen.
 *
 * This state holds the loading status and the list of users.
 *
 * @property loading Whether the user list is being loaded.
 * @property users The list of users available in the home screen.
 */
@Immutable
data class HomeState(
    val loading: Boolean, val users: List<User>
) : Reducer.ViewState {

    /**
     * Provides the initial state of the Home screen.
     *
     * @return An instance of [HomeState] with default values.
     */
    companion object {
        fun initial() = HomeState(
            loading = false, users = emptyList()
        )
    }
}