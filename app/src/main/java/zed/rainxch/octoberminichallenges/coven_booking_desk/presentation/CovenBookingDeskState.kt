package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Desk

data class CovenBookingDeskState(
    val desks: List<Desk> = emptyList(),
    val selectedDesk: Desk? = null,
)
