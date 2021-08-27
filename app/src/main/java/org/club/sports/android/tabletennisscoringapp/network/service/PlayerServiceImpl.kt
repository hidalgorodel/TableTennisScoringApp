package org.club.sports.android.tabletennisscoringapp.network.service

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.club.sports.android.tabletennisscoringapp.domain.Player
import org.club.sports.android.tabletennisscoringapp.util.FirebaseUtils

class PlayerServiceImpl : PlayerService {

    private val firestore = FirebaseUtils.getFirestore()

    override fun getPlayers(): List<Player> {
        TODO("Not yet implemented")
    }
}