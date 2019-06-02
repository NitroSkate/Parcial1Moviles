package com.example.parcial1moviles.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.RoomDatabase
import com.example.parcial1moviles.Entities.Matches
import com.example.parcial1moviles.Repository.MatchesRepository
import com.example.parcial1moviles.Room.MatchesRoomDatabase
import kotlinx.coroutines.launch

class MatchesViewmodel(application: Application) : AndroidViewModel(application){
    private val repository: MatchesRepository


    val allData: LiveData<List<Matches>>

    init{
        val matchesDao = MatchesRoomDatabase.getDatabase(application).matchesDao()
        repository = MatchesRepository(matchesDao)
        allData = repository.allData
    }

    fun insert(matches: Matches) = viewModelScope.launch {
        repository.insert(matches)
    }

}