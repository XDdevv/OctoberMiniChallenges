package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import zed.rainxch.octoberminichallenges.R
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Desk
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.models.Reservation

class CovenBookingDeskViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(CovenBookingDeskState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                loadInitialData()

                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = CovenBookingDeskState()
        )

    private fun loadInitialData() {
        viewModelScope.launch {
            val desks = listOf(
                Desk(
                    name = "Morgana",
                    imageRes = R.drawable.char_1,
                    reservation = Reservation("Oct 31", "02:00")
                ),
                Desk(
                    name = "Selene",
                    imageRes = R.drawable.char_2,
                    reservation = Reservation("Oct 30", "01:00")
                ),
                Desk(
                    name = "Hecate",
                    imageRes = R.drawable.char_3,
                    reservation = Reservation("Oct 30", "02:00")
                ),
                Desk(
                    name = "Elvira",
                    imageRes = R.drawable.char_4,
                    reservation = Reservation("Nov 1", "03:00")
                ),
                Desk(
                    name = "Nyx",
                    imageRes = R.drawable.char_5,
                ),
                Desk(
                    name = "Circe",
                    imageRes = R.drawable.char_6,
                    reservation = Reservation("Oct 30", "05:00")
                )
            )

            _state.update {
                it.copy(
                    desks = desks
                )
            }
        }
    }

    fun onAction(action: CovenBookingDeskAction) {
        when (action) {
            is CovenBookingDeskAction.OnDeskClick -> {
                _state.update { it.copy(
                    selectedDesk = action.desk
                ) }
            }
            CovenBookingDeskAction.OnPrimaryButtonClick -> TODO()
        }
    }

}