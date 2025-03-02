package com.github.home.presentation.mvi.state

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import javax.annotation.concurrent.Immutable


@Immutable
data class HomeState(
    val loading: Boolean,
    val users: List<User>
) : Reducer.ViewState {

    companion object {
        fun initial() = HomeState(
            loading = false,
            users = emptyList()
        )
    }

}