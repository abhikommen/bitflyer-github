package com.github.home.data.remote

import com.github.home.data.remote.dto.RemoteUserDetailDto
import com.github.home.data.remote.dto.RemoteUserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {

    @GET("users")
    suspend fun getUsers(
        @Query("since") since: Int = 0,
        @Query("per_page") perPage: Int = 30
    ): List<RemoteUserDto>

    @GET("users/{username}")
    suspend fun getUserDetail(
        @Path("username") username: String
    ): RemoteUserDetailDto
}