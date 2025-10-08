package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Desk

sealed interface CovenBookingDeskAction {
    data class OnDeskClick(val desk: Desk) : CovenBookingDeskAction
    data object OnPrimaryButtonClick : CovenBookingDeskAction
}