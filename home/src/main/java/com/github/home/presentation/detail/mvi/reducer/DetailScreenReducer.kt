package com.github.home.presentation.detail.mvi.reducer

import com.github.common.utility.base.Reducer
import com.github.home.presentation.detail.mvi.effect.DetailEffect
import com.github.home.presentation.detail.mvi.event.DetailEvent
import com.github.home.presentation.detail.mvi.state.DetailState

/**
 * Reducer for handling state transitions in the Detail screen.
 *
 * This class processes [DetailEvent]s and updates the [DetailState] accordingly,
 * optionally producing a [DetailEffect].
 */
class DetailScreenReducer : Reducer<DetailState, DetailEvent, DetailEffect> {

    /**
     * Reduces the current state based on the received event.
     *
     * @param previousState The current state before applying the event.
     * @param event The event that occurred.
     * @return A new state and an optional side effect.
     */
    override fun reduce(
        previousState: DetailState,
        event: DetailEvent
    ): Pair<DetailState, DetailEffect?> {
        return when (event) {
            is DetailEvent.DetailLoading -> {
                previousState.copy(loading = event.isLoading) to null
            }

            is DetailEvent.DetailLoaded -> {
                previousState.copy(userDetail = event.userDetail, loading = false) to null
            }
        }
    }
}
