package com.github.home.domain.usecase

import com.github.home.data.mappers.toDomain
import com.github.home.domain.model.UserDetail
import com.github.home.domain.repository.GitHubUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Use case for fetching and refreshing GitHub user details.
 *
 * This use case interacts with the [GitHubUserRepository] to fetch user details
 * and map them to the domain model.
 *
 * @property repository The repository handling user data operations.
 */
class GetGitHubUserDetailUseCase(
    private val repository: GitHubUserRepository
) {

    /**
     * Retrieves a flow of user details mapped to the domain model.
     *
     * @param username The GitHub username of the user.
     * @return A [Flow] emitting the mapped [UserDetail] object or null if not found.
     */
    fun getUserFlow(username: String): Flow<UserDetail?> {
        return repository.getUserDetailFlow(username = username).map { userDetail ->
            userDetail?.toDomain()
        }
    }

    /**
     * Refreshes the user details by fetching updated data from the remote source.
     *
     * @param username The GitHub username of the user to refresh.
     */
    suspend fun refreshUserDetail(username: String) {
        repository.refreshUserDetail(username)
    }
}
