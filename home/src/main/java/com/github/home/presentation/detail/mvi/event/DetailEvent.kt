package com.github.home.presentation.detail.mvi.event

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.UserDetail
import javax.annotation.concurrent.Immutable

/**
 * Represents events that can occur in the Detail screen.
 *
 * These events are used to trigger state updates in the ViewModel.
 */
@Immutable
sealed class DetailEvent : Reducer.ViewEvent {

    /**
     * Event to indicate the loading state of user details.
     *
     * @property isLoading Whether the user detail is being loaded.
     */
    data class DetailLoading(val isLoading: Boolean) : DetailEvent()

    /**
     * Event triggered when user details are successfully loaded.
     *
     * @property userDetail The loaded [UserDetail] object.
     */
    data class DetailLoaded(val userDetail: UserDetail) : DetailEvent()
}
