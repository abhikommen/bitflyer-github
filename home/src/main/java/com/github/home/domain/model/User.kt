package com.github.home.domain.model

/**
 * Represents a GitHub user in the domain layer.
 *
 * This data class is used to maintain a clean architecture by separating
 * domain logic from data and presentation layers.
 *
 * @property id Unique identifier of the user.
 * @property username GitHub username of the user.
 * @property fullName Full name of the user (nullable).
 * @property avatarUrl URL of the user's profile picture.
 * @property company Name of the company the user is associated with (nullable).
 * @property blog URL of the user's blog or website (nullable).
 * @property location Physical location of the user (nullable).
 * @property bio Short biography of the user (nullable).
 * @property publicRepos Number of public repositories owned by the user.
 * @property followers Number of followers the user has.
 * @property following Number of users the user is following.
 */
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
