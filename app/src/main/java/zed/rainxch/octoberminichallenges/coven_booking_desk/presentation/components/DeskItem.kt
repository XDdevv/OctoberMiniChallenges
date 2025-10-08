package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.octoberminichallenges.R
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Desk
import zed.rainxch.octoberminichallenges.ui.theme.CovenBookingDeskColors
import zed.rainxch.octoberminichallenges.ui.theme.cinzelFontFamily
import kotlin.random.Random

@Composable
fun DeskItem(
    desk: Desk,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Column(
        modifier = modifier
            .width(118.dp)
            .background(if (isSelected) CovenBookingDeskColors.textPrimary else CovenBookingDeskColors.outlineActive)
            .combinedClickable(
                onClick = onClick
            )
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(desk.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            )

            Image(
                painter = painterResource(R.drawable.ic_border),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(
                    color = if (isSelected) {
                        CovenBookingDeskColors.frameActive
                    } else CovenBookingDeskColors.frameInactive
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 6.dp)
                .align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
        ) {
            val iconRes = remember(desk.name) {
                if (Random.nextBoolean()) {
                    R.drawable.ic_moon
                } else R.drawable.ic_star
            }

            Icon(
                imageVector = ImageVector.vectorResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(8.dp),
                tint = CovenBookingDeskColors.textPrimary
            )

            Text(
                text = desk.name,
                fontFamily = cinzelFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = if (isSelected) {
                    CovenBookingDeskColors.textActive
                } else CovenBookingDeskColors.textPrimary
            )

            Icon(
                imageVector = ImageVector.vectorResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(8.dp),
                tint = CovenBookingDeskColors.textPrimary
            )
        }
    }
}

@Preview
@Composable
private fun DeskItemPreview() {
    DeskItem(
        desk = Desk(
            name = "Elvira",
            imageRes = R.drawable.char_1
        ),
        onClick = {}
    )
}

@Preview
@Composable
private fun DeskItemSelectedPreview() {
    DeskItem(
        desk = Desk(
            name = "Elvira",
            imageRes = R.drawable.char_1,
        ),
        onClick = {},
        isSelected = true
    )
}
