package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.octoberminichallenges.R
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.components.CovenBookingDeskButton
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.components.DeskItem
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Desk
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Reservation
import zed.rainxch.octoberminichallenges.ui.theme.CovenBookingDeskColors
import zed.rainxch.octoberminichallenges.ui.theme.OctoberMiniChallengesTheme
import zed.rainxch.octoberminichallenges.ui.theme.cinzelFontFamily
import zed.rainxch.octoberminichallenges.ui.theme.montserratFontFamily

@Composable
fun CovenBookingDeskRoot(
    viewModel: CovenBookingDeskViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CovenBookingDeskScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun CovenBookingDeskScreen(
    state: CovenBookingDeskState,
    onAction: (CovenBookingDeskAction) -> Unit,
) {
    Scaffold(
        containerColor = CovenBookingDeskColors.bg,
        topBar = {
            Text(
                text = "Coven Booking Desk",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = cinzelFontFamily,
                color = CovenBookingDeskColors.textPrimary,
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(
                        top = 36.dp,
                        bottom = 16.dp,
                        start = 32.dp,
                        end = 32.dp
                    )
            )
        },
        bottomBar = {
            Image(
                painter = painterResource(R.drawable.bottom_bar_img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.desks) { desk ->
                    DeskItem(
                        desk = desk,
                        onClick = {
                            onAction(CovenBookingDeskAction.OnDeskClick(desk))
                        },
                        isSelected = state.selectedDesk == desk
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            if (state.selectedDesk?.reservation == null) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No reservation",
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 21.sp,
                        color = CovenBookingDeskColors.textPrimary
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Booked:",
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 21.sp,
                        color = CovenBookingDeskColors.textPrimary
                    )

                    Text(
                        text = "${state.selectedDesk.reservation.date} ${state.selectedDesk.reservation.time}",
                        fontFamily = cinzelFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        color = CovenBookingDeskColors.textPrimary
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            CovenBookingDeskButton(
                title = if (state.selectedDesk?.reservation == null) {
                    "Choose arrival date"
                } else "Change date",
                onClick = {
                    onAction(CovenBookingDeskAction.OnPrimaryButtonClick)
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    OctoberMiniChallengesTheme {
        CovenBookingDeskScreen(
            state = CovenBookingDeskState(
                selectedDesk = Desk(
                    name = "",
                    imageRes = 0,
                    reservation = Reservation("10 Oct", "01:00")
                )
            ),
            onAction = {}
        )
    }
}