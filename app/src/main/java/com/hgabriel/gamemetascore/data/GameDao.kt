package com.hgabriel.gamemetascore.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Query("SELECT * FROM game order by totalRating DESC")
    fun getGamesByRating(): Flow<List<Game>>

    @Query("SELECT * FROM game order by UPPER(name) ASC")
    fun getGamesByName(): Flow<List<Game>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: Game)

    @Delete
    fun delete(game: Game)
}
