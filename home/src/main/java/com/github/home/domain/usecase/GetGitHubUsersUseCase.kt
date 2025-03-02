package com.github.home.domain.usecase

import com.github.home.data.repository.GitHubUserRepository
import com.github.home.domain.mappers.toDomainModel
import com.github.home.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

class GetGitHubUsersUseCase(
    private val repository: GitHubUserRepository
) {
    fun getUsersFlow(): Flow<List<User>> {
        return repository.getAllUsersFlow().map { users ->
            users.map { it.toDomainModel() }
        }
    }

    suspend fun refreshUsers() {
        repository.refreshUsers()
    }
}