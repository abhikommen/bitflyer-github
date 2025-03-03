package com.github.home.data.mappers

import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.domain.model.UserDetail

/**
 * Extension function to map [UserDetailEntity] to a domain model [UserDetail].
 *
 * This conversion is useful for maintaining separation of concerns between
 * the data layer (Room database) and the domain layer (business logic).
 *
 * @receiver The [UserDetailEntity] object from the database.
 * @return A mapped [UserDetail] domain object.
 */
fun UserDetailEntity.toDomain(): UserDetail {
    return UserDetail(
        id = id,
        username = login,
        avatarUrl = avatarUrl,
        profileUrl = htmlUrl,
        bio = bio,
        name = name,
        company = company,
        blog = blog,
        location = location,
        twitterUsername = twitterUsername,
        publicRepos = publicRepos,
        publicGists = publicGists,
        followers = followers,
        following = following,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
