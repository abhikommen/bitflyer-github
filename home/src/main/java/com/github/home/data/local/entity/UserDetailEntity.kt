package com.github.home.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a User Detail entity stored in the local Room database.
 *
 * @property id Unique identifier for the user.
 * @property login The username of the user.
 * @property nodeId The GitHub Node ID of the user.
 * @property avatarUrl URL to the user's avatar image.
 * @property gravatarId Deprecated Gravatar ID (usually an empty string).
 * @property url API endpoint URL for the user.
 * @property htmlUrl GitHub profile page URL.
 * @property followersUrl API endpoint for retrieving the user's followers.
 * @property followingUrl API endpoint for retrieving the user's following list.
 * @property gistsUrl API endpoint for the user's gists.
 * @property starredUrl API endpoint for repositories starred by the user.
 * @property subscriptionsUrl API endpoint for the user's subscriptions.
 * @property organizationsUrl API endpoint for the user's organizations.
 * @property reposUrl API endpoint for the user's repositories.
 * @property eventsUrl API endpoint for the user's events.
 * @property receivedEventsUrl API endpoint for events received by the user.
 * @property type Type of user (e.g., "User" or "Organization").
 * @property userViewType Custom type for UI representation.
 * @property siteAdmin Whether the user is a site administrator.
 * @property name The real name of the user (nullable).
 * @property company The company the user is associated with (nullable).
 * @property blog The user's personal website or blog URL (nullable).
 * @property location The location of the user (nullable).
 * @property email The user's email address (nullable).
 * @property hireable Whether the user is available for hiring (nullable).
 * @property bio A short biography of the user (nullable).
 * @property twitterUsername The user's Twitter handle (nullable).
 * @property publicRepos The number of public repositories owned by the user.
 * @property publicGists The number of public gists owned by the user.
 * @property followers The number of followers the user has.
 * @property following The number of users the user is following.
 * @property createdAt The timestamp of when the user account was created.
 * @property updatedAt The timestamp of the last profile update.
 */
@Entity(tableName = "user_details")
data class UserDetailEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val nodeId: String,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val receivedEventsUrl: String,
    val type: String,
    val userViewType: String,
    val siteAdmin: Boolean,
    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val email: String? = null,
    val hireable: Boolean? = null,
    val bio: String? = null,
    val twitterUsername: String? = null,
    val publicRepos: Int,
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    val createdAt: String,
    val updatedAt: String
)

