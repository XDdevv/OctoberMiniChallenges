package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class CovenBookingDeskViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(CovenBookingDeskState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = CovenBookingDeskState()
        )

    fun onAction(action: CovenBookingDeskAction) {
        when (action) {
            else -> TODO("Handle actions")
        }
    }

}