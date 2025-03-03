package com.github.home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.data.local.entity.UserEntity

/**
 * Room Database for storing user-related data.
 *
 * This database contains two tables:
 * - `users` (represented by [UserEntity]) for general user data.
 * - `user_details` (represented by [UserDetailEntity]) for detailed user information.
 *
 * @version 1
 * @exportSchema false (schema export is disabled for simplicity)
 */
@Database(
    entities = [UserEntity::class, UserDetailEntity::class], version = 1, exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    /**
     * Provides access to the DAO for user-related database operations.
     *
     * @return An instance of [UserDao].
     */
    abstract fun userDao(): UserDao
}

