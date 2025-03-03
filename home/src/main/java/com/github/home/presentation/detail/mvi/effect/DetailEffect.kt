package com.github.home.presentation.detail.mvi.effect

import com.github.common.utility.base.Reducer
import javax.annotation.concurrent.Immutable

/**
 * Represents one-time UI effects in the Detail screen.
 *
 * These effects are typically used for navigation, showing toasts, or triggering
 * other side effects that should not persist in the ViewModel state.
 */
@Immutable
sealed class DetailEffect : Reducer.ViewEffect {

    /**
     * Effect to navigate back to the Home screen.
     */
    data object NavigateToHome : DetailEffect()
}
