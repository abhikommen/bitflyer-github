// data/repository/GitHubUserRepository.kt
package com.github.home.data.repository

import com.github.home.data.remote.GitHubApiService
import com.github.home.data.remote.dto.RemoteUserDto
import com.github.home.data.remote.dto.RemoteUserDetailDto
import com.github.home.data.local.UserDao
import com.github.home.data.local.entity.UserEntity
import com.github.home.data.mappers.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

/**
 * This repository uses Room (UserDao) as the single source of truth.
 * Network calls (GitHubApiService) are used to refresh data in the DB.
 */
@Singleton
class GitHubUserRepository @Inject constructor(
    private val userDao: UserDao
) {

    private val apiService: GitHubApiService by lazy {
        // Or inject this if you prefer
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .build()
            .create()
    }

    /**
     * Return a flow of user list from the DB. The UI will collect this flow
     * to display offline data immediately. We also provide a `refreshUsers()`
     * method to update DB from network.
     */
    fun getAllUsersFlow(): Flow<List<UserEntity>> {
        return userDao.getAllUsersFlow().distinctUntilChanged()
    }

    /**
     * Retrieve a single user (detail) from DB as Flow. The UI can collect it
     * and always be up to date.
     */
    fun getUserFlow(username: String): Flow<UserEntity?> {
        return userDao.getUserFlow(username).distinctUntilChanged()
    }

    /**
     * Refresh user list from network and store in DB.
     */
    suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
            try {
                val remoteUsers = apiService.getUsers(since = 0, perPage = 30)
                val entities = remoteUsers.map { it.toEntity() }
                userDao.insertOrUpdateUsers(entities)
            } catch (e: Exception) {
                // Log or handle network error
            }
        }
    }

    /**
     * Refresh user detail from network and store in DB. 
     */
    suspend fun refreshUserDetail(username: String) {
        withContext(Dispatchers.IO) {
            try {
                val remoteDetail = apiService.getUserDetail(username)
                val entity = remoteDetail.toEntity()
                userDao.insertOrUpdateUser(entity)
            } catch (e: Exception) {
                // Log or handle network error
            }
        }
    }

}
