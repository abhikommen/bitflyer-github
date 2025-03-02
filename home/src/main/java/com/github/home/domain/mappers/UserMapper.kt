package com.github.home.domain.mappers

import com.github.home.data.local.entity.UserEntity
import com.github.home.domain.model.User

fun UserEntity.toDomainModel(): User {
    return User(
        id = this.id,
        username = this.login,
        fullName = this.name,
        avatarUrl = this.avatarUrl,
        company = this.company,
        blog = this.blog,
        location = this.location,
        bio = this.bio,
        publicRepos = this.publicRepos,
        followers = this.followersCount,
        following = this.followingCount
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        login = this.username,
        name = this.fullName,
        avatarUrl = this.avatarUrl,
        company = this.company,
        blog = this.blog,
        location = this.location,
        bio = this.bio,
        publicRepos = this.publicRepos,
        followersCount = this.followers,
        followingCount = this.following
    )
}