package com.github.home.domain.usecase

import com.github.home.data.local.entity.UserEntity
import com.github.home.data.repository.GitHubUserRepository
import kotlinx.coroutines.flow.Flow

class GetGitHubUserDetailUseCase(
    private val repository: GitHubUserRepository
) {
    fun getUserFlow(username: String): Flow<UserEntity?> {
        return repository.getUserFlow(username)
    }

    suspend fun refreshUserDetail(username: String) {
        repository.refreshUserDetail(username)
    }
}