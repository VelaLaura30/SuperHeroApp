package com.example.superheroapp.di

import com.example.superheroapp.ui.screens.enemies.rv.RVEnemiesAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object EnemiesModule {

    @Provides
    fun provideRVEnemiesAdapter(): RVEnemiesAdapter {
        return RVEnemiesAdapter()
    }
}
