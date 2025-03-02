package com.github.home.presentation.mvi.reducer

import com.github.common.utility.base.Reducer
import com.github.home.presentation.mvi.effect.HomeEffect
import com.github.home.presentation.mvi.event.HomeEvent
import com.github.home.presentation.mvi.state.HomeState

class HomeScreenReducer : Reducer<HomeState, HomeEvent, HomeEffect> {
    override fun reduce(previousState: HomeState, event: HomeEvent): Pair<HomeState, HomeEffect?> {
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