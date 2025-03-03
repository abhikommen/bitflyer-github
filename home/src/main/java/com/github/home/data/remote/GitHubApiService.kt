package com.github.home.data.remote

import com.github.home.data.remote.dto.RemoteUserDetailDto
import com.github.home.data.remote.dto.RemoteUserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * API service for interacting with GitHub's user-related endpoints.
 */
interface GitHubApiService {

    /**
     * Fetches a list of GitHub users.
     *
     * @param since The user ID to start fetching from (pagination).
     * @param perPage The number of users to retrieve per request (default is 30).
     * @return A list of [RemoteUserDto] containing basic user information.
     */
    @GET("users")
    suspend fun getUsers(
        @Query("since") since: Int = 0,
        @Query("per_page") perPage: Int = 30
    ): List<RemoteUserDto>

    /**
     * Fetches detailed information about a specific GitHub user.
     *
     * @param username The GitHub username of the user to fetch.
     * @return A [RemoteUserDetailDto] containing detailed user information.
     */
    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): RemoteUserDetailDto
}
