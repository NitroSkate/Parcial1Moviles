package com.example.parcial1moviles.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName  = "matches")
data class Matches (
    @ColumnInfo(name = "team1") val team1 : String,
    @ColumnInfo(name = "team2") val team2: String,
    @ColumnInfo(name = "points1") val points1 : Int,
    @ColumnInfo(name = "points2") val points2 : Int,
    @ColumnInfo(name = "winner") val winner: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "time") val time: String
){@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")var id : Long = 0 }