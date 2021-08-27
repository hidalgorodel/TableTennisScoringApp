package org.club.sports.android.tabletennisscoringapp.util

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.club.sports.android.tabletennisscoringapp.network.service.PlayerService
import org.club.sports.android.tabletennisscoringapp.network.service.PlayerServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Singleton
    @Binds
    abstract fun bindPlayerService(
        playerServiceImpl: PlayerServiceImpl
    ): PlayerService
}