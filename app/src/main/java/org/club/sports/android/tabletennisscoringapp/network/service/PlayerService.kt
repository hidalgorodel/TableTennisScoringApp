package org.club.sports.android.tabletennisscoringapp.network.service

import org.club.sports.android.tabletennisscoringapp.domain.Player

interface PlayerService {

    fun getPlayers(): List<Player>
}