package com.github.home.domain.usecase

import com.github.home.domain.mappers.toDomainModel
import com.github.home.domain.model.User
import com.github.home.domain.repository.GitHubUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

/**
 * Use case for fetching and refreshing the list of GitHub users.
 *
 * This use case interacts with the [GitHubUserRepository] to fetch the user list
 * and map it to the domain model.
 *
 * @property repository The repository handling user data operations.
 */
class GetGitHubUsersUseCase(
    private val repository: GitHubUserRepository
) {

    /**
     * Retrieves a flow of all users mapped to the domain model.
     *
     * @return A [Flow] emitting a list of [User] objects.
     */
    fun getUsersFlow(): Flow<List<User>> {
        return repository.getAllUsersFlow().map { users ->
            users.map { it.toDomainModel() }
        }
    }

    /**
     * Refreshes the user list by fetching updated data from the remote source.
     */
    suspend fun refreshUsers() {
        repository.refreshUsers()
    }
}
