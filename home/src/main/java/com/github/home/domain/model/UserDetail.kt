package com.github.home.domain.model

/**
 * Represents detailed information about a GitHub user in the domain layer.
 *
 * This data class is used to maintain a clean architecture by separating
 * domain logic from data and presentation layers.
 *
 * @property id Unique identifier of the user.
 * @property username GitHub username of the user.
 * @property avatarUrl URL of the user's profile picture.
 * @property profileUrl URL of the user's GitHub profile.
 * @property bio Short biography of the user (nullable).
 * @property name Full name of the user (nullable).
 * @property company Name of the company the user is associated with (nullable).
 * @property blog URL of the user's blog or website (nullable).
 * @property location Physical location of the user (nullable).
 * @property twitterUsername Twitter handle of the user (nullable).
 * @property publicRepos Number of public repositories owned by the user.
 * @property publicGists Number of public gists owned by the user.
 * @property followers Number of followers the user has.
 * @property following Number of users the user is following.
 * @property createdAt Timestamp of when the user account was created.
 * @property updatedAt Timestamp of the last profile update.
 */
data class UserDetail(
    val id: Int,
    val username: String,
    val avatarUrl: String,
    val profileUrl: String,
    val bio: String?,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val twitterUsername: String?,
    val publicRepos: Int,
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    val createdAt: String,
    val updatedAt: String
)
