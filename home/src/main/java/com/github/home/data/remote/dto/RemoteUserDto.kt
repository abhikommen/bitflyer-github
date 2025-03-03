package com.github.home.data.remote.dto


import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing a remote user retrieved from the API.
 *
 * This class is used for mapping API responses related to basic user information.
 *
 * @property login The username of the user.
 * @property id The unique identifier of the user.
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
 */
data class RemoteUserDto(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("gravatar_id") val gravatarId: String,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("following_url") val followingUrl: String,
    @SerializedName("gists_url") val gistsUrl: String,
    @SerializedName("starred_url") val starredUrl: String,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String,
    @SerializedName("organizations_url") val organizationsUrl: String,
    @SerializedName("repos_url") val reposUrl: String,
    @SerializedName("events_url") val eventsUrl: String,
    @SerializedName("received_events_url") val receivedEventsUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("user_view_type") val userViewType: String,
    @SerializedName("site_admin") val siteAdmin: Boolean
)

/**
 * Data Transfer Object (DTO) representing detailed user information retrieved from the API.
 *
 * This class contains additional fields that are present in detailed user responses.
 *
 * @property login The username of the user.
 * @property id The unique identifier of the user.
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
data class RemoteUserDetailDto(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("node_id") val nodeId: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("gravatar_id") val gravatarId: String,
    @SerializedName("url") val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("followers_url") val followersUrl: String,
    @SerializedName("following_url") val followingUrl: String,
    @SerializedName("gists_url") val gistsUrl: String,
    @SerializedName("starred_url") val starredUrl: String,
    @SerializedName("subscriptions_url") val subscriptionsUrl: String,
    @SerializedName("organizations_url") val organizationsUrl: String,
    @SerializedName("repos_url") val reposUrl: String,
    @SerializedName("events_url") val eventsUrl: String,
    @SerializedName("received_events_url") val receivedEventsUrl: String,
    @SerializedName("type") val type: String,
    @SerializedName("user_view_type") val userViewType: String,
    @SerializedName("site_admin") val siteAdmin: Boolean,
    @SerializedName("name") val name: String?,
    @SerializedName("company") val company: String?,
    @SerializedName("blog") val blog: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("hireable") val hireable: Boolean?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("twitter_username") val twitterUsername: String?,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("public_gists") val publicGists: Int,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)
