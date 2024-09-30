package com.example.superheroapp.di

import com.example.superheroapp.ui.screens.friends.rv.FriendAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object FriendsModule {

    @Provides
    fun provideFriendAdapter(): FriendAdapter {
        return FriendAdapter()
    }
}
