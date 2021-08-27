package org.club.sports.android.tabletennisscoringapp.ui.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.club.sports.android.tabletennisscoringapp.databinding.FragmentLeaderboardBinding

class LeaderboardFragment : Fragment() {

    private val viewModel: LeaderboardViewModel by viewModels()
    private var _binding: FragmentLeaderboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.leaderboardView.setContent {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = viewModel.text.toString(),
                    style = MaterialTheme.typography.body1,
                    color = Color.Green
                )
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}