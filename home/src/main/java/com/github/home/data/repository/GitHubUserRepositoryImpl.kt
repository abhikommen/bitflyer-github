package com.github.home.data.repository

import com.github.home.data.local.UserDao
import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.data.local.entity.UserEntity
import com.github.home.data.mappers.toEntity
import com.github.home.data.remote.GitHubApiService
import com.github.home.domain.repository.GitHubUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of [GitHubUserRepository] that handles fetching user data
 * from both a remote API and a local database.
 *
 * @property userDao The DAO for accessing local user data.
 * @property apiService The API service for fetching remote user data.
 */
class GitHubUserRepositoryImpl @Inject constructor(
    private val userDao: UserDao, private val apiService: GitHubApiService
) : GitHubUserRepository {

    /**
     * Retrieves a flow of all users from the local database.
     *
     * @return A [Flow] emitting a list of [UserEntity] objects.
     */
    override fun getAllUsersFlow(): Flow<List<UserEntity>> {
        return userDao.getAllUsersFlow().distinctUntilChanged()
    }

    /**
     * Retrieves a flow of user details for a specific username.
     *
     * @param username The GitHub username of the user.
     * @return A [Flow] emitting a [UserDetailEntity] or null if not found.
     */
    override fun getUserDetailFlow(username: String): Flow<UserDetailEntity?> {
        return userDao.getUserFlow(username).distinctUntilChanged()
    }

    /**
     * Fetches the latest users from the remote API and updates the local database.
     *
     * This function runs on the IO dispatcher to ensure database operations do not block the UI thread.
     */
    override suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
            runCatching {
                val remoteUsers = apiService.getUsers(since = 0, perPage = 30)
                val entities = remoteUsers.map { it.toEntity() }
                userDao.insertOrUpdateUsers(entities)
            }.onFailure { it.printStackTrace() }
        }
    }

    /**
     * Fetches detailed information of a specific user from the remote API and updates the local database.
     *
     * This function runs on the IO dispatcher to ensure database operations do not block the UI thread.
     *
     * @param username The GitHub username of the user to refresh.
     */
    override suspend fun refreshUserDetail(username: String) {
        withContext(Dispatchers.IO) {
            runCatching {
                val remoteDetail = apiService.getUserDetail(username)
                val entity = remoteDetail.toEntity()
                userDao.insertOrUpdateUser(entity)
            }.onFailure { it.printStackTrace() }
        }
    }
}
