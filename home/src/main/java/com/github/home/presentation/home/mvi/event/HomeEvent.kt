package com.github.home.presentation.home.mvi.event

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import javax.annotation.concurrent.Immutable

/**
 * Represents events that can occur in the Home screen.
 *
 * These events are used to trigger state updates in the ViewModel.
 */
@Immutable
sealed class HomeEvent : Reducer.ViewEvent {

    /**
     * Event to indicate the loading state of the user list.
     *
     * @property isLoading Whether the user list is being loaded.
     */
    data class HomeListLoading(val isLoading: Boolean) : HomeEvent()

    /**
     * Event triggered when the list of users is successfully loaded.
     *
     * @property topics The list of retrieved [User] objects.
     */
    data class HomeUserList(val topics: List<User>) : HomeEvent()
}