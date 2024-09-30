package com.example.superheroapp.di

import com.example.superheroapp.data.models.Power
import com.example.superheroapp.ui.screen.superhero.rv.RVSuperheroAdapter
import com.example.superheroapp.ui.screens.enemies.rv.RVEnemiesAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SuperHeroModule {

    @Provides
    fun provideRVSuperHeroAdapter(
        allPowers: List<Power>,
        onFriendsClickListener: (id: Int) -> Unit,
        onEnemiesClickListener: (id: Int) -> Unit
    ): RVSuperheroAdapter {
        return RVSuperheroAdapter(
            allPowers = allPowers,
            onFriendsClickListener = onFriendsClickListener,
            onEnemiesClickListener = onEnemiesClickListener
        )
    }
}
