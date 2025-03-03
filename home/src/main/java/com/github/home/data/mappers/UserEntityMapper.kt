package com.github.home.data.mappers

import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.data.local.entity.UserEntity
import com.github.home.data.remote.dto.RemoteUserDetailDto
import com.github.home.data.remote.dto.RemoteUserDto

/**
 * Extension function to map [RemoteUserDto] to a local database entity [UserEntity].
 *
 * This transformation ensures that only the available fields from the remote API
 * are stored while keeping default values for missing data.
 *
 * @receiver The [RemoteUserDto] object retrieved from the API.
 * @return A mapped [UserEntity] object for local storage.
 */
fun RemoteUserDto.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = login,
        name = null, // Not included in the list endpoint
        avatarUrl = avatarUrl,
        company = null,
        blog = null,
        location = null,
        bio = null,
        publicRepos = 0,
        followersCount = 0,
        followingCount = 0
    )
}

/**
 * Extension function to map [RemoteUserDetailDto] to a local database entity [UserDetailEntity].
 *
 * This transformation ensures that detailed user data from the API response is stored
 * in the local database.
 *
 * @receiver The [RemoteUserDetailDto] object retrieved from the API.
 * @return A mapped [UserDetailEntity] object for local storage.
 */
fun RemoteUserDetailDto.toEntity(): UserDetailEntity {
    return UserDetailEntity(
        id = id,
        login = login,
        nodeId = nodeId,
        avatarUrl = avatarUrl,
        gravatarId = gravatarId,
        url = url,
        htmlUrl = htmlUrl,
        followersUrl = followersUrl,
        followingUrl = followingUrl,
        gistsUrl = gistsUrl,
        starredUrl = starredUrl,
        subscriptionsUrl = subscriptionsUrl,
        organizationsUrl = organizationsUrl,
        reposUrl = reposUrl,
        eventsUrl = eventsUrl,
        receivedEventsUrl = receivedEventsUrl,
        type = type,
        userViewType = userViewType,
        siteAdmin = siteAdmin,
        name = name,
        company = company,
        blog = blog,
        location = location,
        email = email,
        hireable = hireable,
        bio = bio,
        twitterUsername = twitterUsername,
        publicRepos = publicRepos,
        publicGists = publicGists,
        followers = followers,
        following = following,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
