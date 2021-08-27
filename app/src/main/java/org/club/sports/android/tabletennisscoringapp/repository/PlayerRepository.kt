package org.club.sports.android.tabletennisscoringapp.repository

import org.club.sports.android.tabletennisscoringapp.domain.Player
import org.club.sports.android.tabletennisscoringapp.network.service.PlayerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepository @Inject constructor(
    private val playerService: PlayerService
)  {

    suspend fun getPlayers(): List<Player> = playerService.getPlayers()
}