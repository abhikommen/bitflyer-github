package com.github.home.data.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.home.data.local.entity.UserDetailEntity
import com.github.home.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for interacting with the User database.
 */
@Dao
interface UserDao {

    /**
     * Retrieves a flow of all users from the database, ordered by login name.
     *
     * @return A [Flow] emitting the list of [UserEntity] objects.
     */
    @Query("SELECT * FROM users ORDER BY login ASC")
    fun getAllUsersFlow(): Flow<List<UserEntity>>

    /**
     * Retrieves a flow of user details for a given username.
     *
     * @param username The GitHub username of the user.
     * @return A [Flow] emitting the [UserDetailEntity] object or null if not found.
     */
    @Query("SELECT * FROM user_details WHERE login = :username LIMIT 1")
    fun getUserFlow(username: String): Flow<UserDetailEntity?>

    /**
     * Inserts or updates a list of users in the database.
     *
     * If a conflict occurs (e.g., duplicate primary key), the existing record is replaced.
     *
     * @param users The list of [UserEntity] objects to be inserted or updated.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUsers(users: List<UserEntity>)

    /**
     * Inserts or updates a single user detail record in the database.
     *
     * If a conflict occurs (e.g., duplicate primary key), the existing record is replaced.
     *
     * @param user The [UserDetailEntity] object to be inserted or updated.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: UserDetailEntity)
}
