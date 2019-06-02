package com.example.parcial1moviles.Repository

import androidx.lifecycle.LiveData
import com.example.parcial1moviles.Daos.MatchesDao
import com.example.parcial1moviles.Entities.Matches

class MatchesRepository(private val matchesDao: MatchesDao){
    val allData: LiveData<List<Matches>> = matchesDao.getAll()


    suspend fun insert(matches: Matches){
        matchesDao.insert(matches)
    }
}