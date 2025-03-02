package com.github.home.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val name: String?,
    val avatarUrl: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val bio: String?,
    val publicRepos: Int,
    val followersCount: Int,
    val followingCount: Int
)