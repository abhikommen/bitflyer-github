package com.github.home.presentation.home.mvi.reducer

import com.github.common.utility.base.Reducer
import com.github.home.presentation.home.mvi.effect.HomeEffect
import com.github.home.presentation.home.mvi.event.HomeEvent
import com.github.home.presentation.home.mvi.state.HomeState

/**
 * Reducer for handling state transitions in the Home screen.
 *
 * This class processes [HomeEvent]s and updates the [HomeState] accordingly,
 * optionally producing a [HomeEffect].
 */
class HomeScreenReducer : Reducer<HomeState, HomeEvent, HomeEffect> {

    /**
     * Reduces the current state based on the received event.
     *
     * @param previousState The current state before applying the event.
     * @param event The event that occurred.
     * @return A new state and an optional side effect.
     */
    override fun reduce(
        previousState: HomeState, event: HomeEvent
    ): Pair<HomeState, HomeEffect?> {
        return when (event) {
            is HomeEvent.HomeListLoading -> {
                previousState.copy(loading = event.isLoading) to null
            }

            is HomeEvent.HomeUserList -> {
                previousState.copy(users = event.topics, loading = false) to null
            }
        }
    }
}
