package org.club.sports.android.tabletennisscoringapp.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.club.sports.android.tabletennisscoringapp.domain.Player

@ExperimentalMaterialApi
@Composable
fun PlayerScoreCard(player: Player, modifier: Modifier = Modifier) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = contentColorFor(SnackbarDefaults.backgroundColor),
        elevation = 1.dp,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Row(modifier = modifier.padding(6.dp)) {
            Surface(
                modifier = modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.2f)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = ""
                )
            }
            Text(
                text = "${player.firstname} ${player.lastname}",
                modifier = modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
                    .weight(2f),
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${player.totalPoints} points",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                style = MaterialTheme.typography.subtitle2
            )
            IconButton(
                modifier = modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1f)
                    .rotate(rotationState),
                onClick = {
                    expandedState = !expandedState
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = ""
                )
            }
        }
        // Expanded view
        if (expandedState) {
            // TODO: PlayerDetailsCard
        }
    }
}


@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun PlayerScoreCardPreview() {
    val player = Player(
        firstname = "Rodel",
        lastname = "Hidalgo",
        email = "rh@mail.co",
        phone = "+63 977 825 5436",
        totalPoints = 100
    )
    PlayerScoreCard(player)
}
