package com.github.home.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RemoteUserDto(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)

data class RemoteUserDetailDto(
    val id: Int,
    val login: String,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val bio: String?,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("followers") val followersCount: Int,
    @SerializedName("following") val followingCount: Int
)