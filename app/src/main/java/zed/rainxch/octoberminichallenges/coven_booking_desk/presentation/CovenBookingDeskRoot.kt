package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.octoberminichallenges.ui.theme.OctoberMiniChallengesTheme

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

}

@Preview
@Composable
private fun Preview() {
    OctoberMiniChallengesTheme {
        CovenBookingDeskScreen(
            state = CovenBookingDeskState(),
            onAction = {}
        )
    }
}