package com.github.home.data.local.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a User entity stored in the local Room database.
 *
 * @property id Unique identifier for the user.
 * @property login The username of the user.
 * @property name The real name of the user (nullable).
 * @property avatarUrl URL to the user's avatar image.
 * @property company The company the user is associated with (nullable).
 * @property blog The user's personal website or blog URL (nullable).
 * @property location The location of the user (nullable).
 * @property bio A short biography of the user (nullable).
 * @property publicRepos The number of public repositories owned by the user.
 * @property followersCount The number of followers the user has.
 * @property followingCount The number of users the user is following.
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val name: String? = null,
    val avatarUrl: String,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val bio: String? = null,
    val publicRepos: Int,
    val followersCount: Int,
    val followingCount: Int
)
