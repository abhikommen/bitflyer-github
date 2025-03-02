package com.github.home.data.mappers

import com.github.home.data.local.entity.UserEntity
import com.github.home.data.remote.dto.RemoteUserDetailDto
import com.github.home.data.remote.dto.RemoteUserDto

fun RemoteUserDto.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        login = this.login,
        name = null,            // not included in the list endpoint
        avatarUrl = this.avatarUrl,
        company = null,
        blog = null,
        location = null,
        bio = null,
        publicRepos = 0,
        followersCount = 0,
        followingCount = 0
    )
}

fun RemoteUserDetailDto.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        login = this.login,
        name = this.name,
        avatarUrl = this.avatarUrl,
        company = this.company,
        blog = this.blog,
        location = this.location,
        bio = this.bio,
        publicRepos = this.publicRepos,
        followersCount = this.followersCount,
        followingCount = this.followingCount
    )
}