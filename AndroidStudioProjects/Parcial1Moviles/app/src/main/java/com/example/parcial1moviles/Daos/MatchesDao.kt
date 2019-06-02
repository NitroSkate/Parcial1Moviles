package com.example.parcial1moviles.Daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.parcial1moviles.Entities.Matches

@Dao
interface MatchesDao {
    @Query("SELECT * FROM matches")
    fun getAll() : LiveData<List<Matches>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(matches : Matches)

}