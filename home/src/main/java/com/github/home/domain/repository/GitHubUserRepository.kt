package com.github.home.domain.repository

import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for handling GitHub user data.
 *
 * This repository defines methods for fetching user lists and user details,
 * both from local storage and remote sources.
 */
interface GitHubUserRepository {

    /**
     * Retrieves a flow of all users from the local database.
     *
     * @return A [Flow] emitting a list of [UserEntity] objects.
     */
    fun getAllUsersFlow(): Flow<List<UserEntity>>

    /**
     * Retrieves a flow of user details for a specific username.
     *
     * @param username The GitHub username of the user.
     * @return A [Flow] emitting a [UserDetailEntity] or null if not found.
     */
    fun getUserDetailFlow(username: String): Flow<UserDetailEntity?>

    /**
     * Fetches the latest users from the remote API and updates the local database.
     */
    suspend fun refreshUsers()

    /**
     * Fetches detailed information of a specific user from the remote API and updates the local database.
     *
     * @param username The GitHub username of the user to refresh.
     */
    suspend fun refreshUserDetail(username: String)
}

