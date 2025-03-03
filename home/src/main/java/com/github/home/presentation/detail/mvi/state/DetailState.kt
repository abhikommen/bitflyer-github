package com.github.home.presentation.detail.mvi.state

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import com.github.home.domain.model.UserDetail
import javax.annotation.concurrent.Immutable

/**
 * Represents the UI state for the Detail screen.
 *
 * This state holds the loading status and user detail information.
 *
 * @property loading Whether the user details are being loaded.
 * @property userDetail The user details, if available.
 */
@Immutable
data class DetailState(
    val loading: Boolean, val userDetail: UserDetail? = null
) : Reducer.ViewState {

    /**
     * Provides the initial state of the Detail screen.
     *
     * @return An instance of [DetailState] with default values.
     */
    companion object {
        fun initial() = DetailState(
            loading = false
        )
    }
}
