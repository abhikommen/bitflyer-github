package com.github.home.presentation.mvi.effect

import com.github.common.utility.base.Reducer
import com.github.home.domain.model.User
import javax.annotation.concurrent.Immutable

@Immutable
sealed class HomeEffect : Reducer.ViewEffect {
    data class NavigateToDetail(val user: User) : HomeEffect()
}