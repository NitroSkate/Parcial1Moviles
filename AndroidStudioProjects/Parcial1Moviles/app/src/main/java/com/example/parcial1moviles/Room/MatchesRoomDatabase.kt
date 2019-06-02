package com.example.parcial1moviles.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial1moviles.Daos.MatchesDao
import com.example.parcial1moviles.Entities.Matches

@Database(entities = [Matches::class], version = 2, exportSchema = false)
abstract class MatchesRoomDatabase : RoomDatabase() {

    abstract fun matchesDao(): MatchesDao

    companion object {
        @Volatile
        private var INSTANCE: MatchesRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): MatchesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MatchesRoomDatabase::class.java,
                    "matches_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}