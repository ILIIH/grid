package com.example.android.codelabs.paging.db

import androidx.room.*

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey
    val repoId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)

@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE repoId = :repoId")
    suspend fun remoteKeysRepoId(repoId: Long): RemoteKeys?

    @Query("DELETE FROM remote_keys")
    suspend fun clearRemoteKeys()
}
