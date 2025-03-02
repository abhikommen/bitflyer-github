package com.github.home.presentation.mvi.event

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import javax.annotation.concurrent.Immutable

@Immutable
sealed class HomeEvent : Reducer.ViewEvent {
    data class HomeListLoading(val isLoading: Boolean) : HomeEvent()
    data class HomeUserList(val topics: List<User>) : HomeEvent()
}