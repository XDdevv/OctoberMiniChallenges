package zed.rainxch.octoberminichallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.CovenBookingDeskRoot
import zed.rainxch.octoberminichallenges.ui.theme.OctoberMiniChallengesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var showSplash = true
        lifecycleScope.launch {
//            delay(6000)
            showSplash = false
        }

        installSplashScreen().setKeepOnScreenCondition {
            showSplash
        }

        enableEdgeToEdge()
        setContent {
            OctoberMiniChallengesTheme {
                CovenBookingDeskRoot()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OctoberMiniChallengesTheme {
        Greeting("Android")
    }
}