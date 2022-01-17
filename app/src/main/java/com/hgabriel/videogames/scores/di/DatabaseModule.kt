package com.hgabriel.videogames.scores.di

import android.content.Context
import androidx.room.Room
import com.hgabriel.videogames.scores.data.GameDao
import com.hgabriel.videogames.scores.data.GameDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideGameDatabase(@ApplicationContext appContext: Context): GameDatabase =
        Room
            .databaseBuilder(appContext, GameDatabase::class.java, "games.db")
            .build()

    @Provides
    fun provideGameDao(db: GameDatabase): GameDao = db.gameDao()
}
