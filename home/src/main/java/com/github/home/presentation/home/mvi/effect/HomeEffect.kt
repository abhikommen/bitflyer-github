package com.github.home.presentation.home.mvi.effect

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import com.github.home.presentation.detail.mvi.effect.DetailEffect
import javax.annotation.concurrent.Immutable

/**
 * Represents one-time UI effects in the Home screen.
 *
 * These effects are typically used for navigation, showing toasts, or triggering
 * other side effects that should not persist in the ViewModel state.
 */
@Immutable
sealed class HomeEffect : Reducer.ViewEffect {

    /**
     * Effect to navigate to the Detail screen with the selected user.
     *
     * @property user The user whose details are to be displayed.
     */
    data class NavigateToDetail(val user: User) : HomeEffect()
}