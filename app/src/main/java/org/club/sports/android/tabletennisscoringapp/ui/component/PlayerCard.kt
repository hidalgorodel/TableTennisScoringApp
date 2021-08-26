package org.club.sports.android.tabletennisscoringapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.club.sports.android.tabletennisscoringapp.domain.Player

@Composable
fun PlayerCard(player: Player, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = contentColorFor(backgroundColor),
        elevation = 1.dp
    ) {
        Row {
            Surface(
                modifier = modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                // Place image here
            }
            Column(
                modifier = modifier
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "${player.firstname} ${player.lastname}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.ExtraBold
                )
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "E-mail: ${player.email}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    if (player.phone != null) {
                        Text(
                            text = "Mobile: ${player.phone}",
                            style = MaterialTheme.typography.subtitle1
                        )
                    }
                    Text(
                        text = "${player.totalPoints} points",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerCardPreview() {
    val player = Player(
        firstname = "Rodel",
        lastname = "Hidalgo",
        email = "rh@mail.co",
        phone = "+63 977 825 5436",
        totalPoints = 100
    )

    PlayerCard(player = player)
}