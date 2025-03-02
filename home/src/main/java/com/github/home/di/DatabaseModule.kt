package com.github.home.di

import android.content.Context
import androidx.room.Room
import com.github.home.data.local.UserDao
import com.github.home.data.local.UserDatabase
import com.github.home.data.repository.GitHubUserRepository
import com.github.home.domain.usecase.GetGitHubUserDetailUseCase
import com.github.home.domain.usecase.GetGitHubUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.databaseBuilder(
            context, UserDatabase::class.java, "user_database"
        ).build()
    }

    @Provides
    fun provideUserDao(db: UserDatabase): UserDao {
        return db.userDao()
    }

    // Provide the Repository
    @Provides
    @Singleton
    fun provideGitHubUserRepository(
        userDao: UserDao
    ): GitHubUserRepository {
        return GitHubUserRepository(userDao)
    }

    // Provide Use Cases
    @Provides
    fun provideGetGitHubUsersUseCase(
        repository: GitHubUserRepository
    ): GetGitHubUsersUseCase {
        return GetGitHubUsersUseCase(repository)
    }

    @Provides
    fun provideGetGitHubUserDetailUseCase(
        repository: GitHubUserRepository
    ): GetGitHubUserDetailUseCase {
        return GetGitHubUserDetailUseCase(repository)
    }
}
