package org.club.sports.android.tabletennisscoringapp.ui.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.club.sports.android.tabletennisscoringapp.domain.Player
import org.club.sports.android.tabletennisscoringapp.repository.PlayerRepository
import javax.inject.Inject

@HiltViewModel
class LeaderboardViewModel @Inject constructor(
    playerRepository: PlayerRepository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is leaderboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    init {
        viewModelScope.launch {
            _players.value = playerRepository.getPlayers()
        }
    }
}