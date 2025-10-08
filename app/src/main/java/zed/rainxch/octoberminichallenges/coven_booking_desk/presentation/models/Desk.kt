package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models

import androidx.annotation.DrawableRes

data class Desk(
    val name: String,
    @DrawableRes val imageRes: Int,
    val reservation: Reservation? = null,
)

data class Reservation(
    val date: String,
    val time: String,
)
