package com.github.home.di

import android.content.Context
import androidx.room.Room
import com.github.home.data.local.UserDao
import com.github.home.data.local.UserDatabase
import com.github.home.data.remote.GitHubApiService
import com.github.home.data.repository.GitHubUserRepositoryImpl
import com.github.home.domain.repository.GitHubUserRepository
import com.github.home.domain.usecase.GetGitHubUserDetailUseCase
import com.github.home.domain.usecase.GetGitHubUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt module for providing dependencies related to database, repository, and use cases.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Provides the Room database instance.
     *
     * @param context The application context.
     * @return A [UserDatabase] instance.
     */
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "user_database"
        ).build()
    }

    /**
     * Provides the UserDao from the database.
     *
     * @param db The [UserDatabase] instance.
     * @return The [UserDao] instance.
     */
    @Provides
    fun provideUserDao(db: UserDatabase): UserDao {
        return db.userDao()
    }

    /**
     * Provides the GitHub user repository implementation.
     *
     * @param userDao The DAO for accessing user data.
     * @param apiService The API service for fetching remote user data.
     * @return An instance of [GitHubUserRepository].
     */
    @Provides
    @Singleton
    fun provideGitHubUserRepository(
        userDao: UserDao,
        apiService: GitHubApiService
    ): GitHubUserRepository {
        return GitHubUserRepositoryImpl(userDao, apiService)
    }

    /**
     * Provides the use case for fetching GitHub users.
     *
     * @param repository The GitHub user repository.
     * @return An instance of [GetGitHubUsersUseCase].
     */
    @Provides
    fun provideGetGitHubUsersUseCase(
        repository: GitHubUserRepository
    ): GetGitHubUsersUseCase {
        return GetGitHubUsersUseCase(repository)
    }

    /**
     * Provides the use case for fetching GitHub user details.
     *
     * @param repository The GitHub user repository.
     * @return An instance of [GetGitHubUserDetailUseCase].
     */
    @Provides
    fun provideGetGitHubUserDetailUseCase(
        repository: GitHubUserRepository
    ): GetGitHubUserDetailUseCase {
        return GetGitHubUserDetailUseCase(repository)
    }
}
