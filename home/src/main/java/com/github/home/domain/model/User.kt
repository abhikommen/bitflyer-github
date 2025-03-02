package com.github.home.domain.model

data class User(
    val id: Int,
    val username: String,
    val fullName: String?,
    val avatarUrl: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val bio: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int
)
