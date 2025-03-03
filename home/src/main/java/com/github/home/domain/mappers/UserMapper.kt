package com.github.home.domain.mappers

import com.github.home.data.local.entity.UserEntity
import com.github.home.domain.model.User

/**
 * Extension function to map [UserEntity] from the local database to a domain model [User].
 *
 * This transformation helps in maintaining a clean architecture by keeping the data layer
 * separate from the domain layer.
 *
 * @receiver The [UserEntity] object retrieved from the database.
 * @return A mapped [User] domain object.
 */
fun UserEntity.toDomainModel(): User {
    return User(
        id = id,
        username = login,
        fullName = name,
        avatarUrl = avatarUrl,
        company = company,
        blog = blog,
        location = location,
        bio = bio,
        publicRepos = publicRepos,
        followers = followersCount,
        following = followingCount
    )
}

/**
 * Extension function to map [User] from the domain model to a local database entity [UserEntity].
 *
 * This transformation ensures proper separation between domain logic and database implementation.
 *
 * @receiver The [User] domain model.
 * @return A mapped [UserEntity] for local database storage.
 */
fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = username,
        name = fullName,
        avatarUrl = avatarUrl,
        company = company,
        blog = blog,
        location = location,
        bio = bio,
        publicRepos = publicRepos,
        followersCount = followers,
        followingCount = following
    )
}
