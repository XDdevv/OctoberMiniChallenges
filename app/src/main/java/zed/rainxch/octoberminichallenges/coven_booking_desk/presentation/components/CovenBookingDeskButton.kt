package zed.rainxch.octoberminichallenges.coven_booking_desk.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.octoberminichallenges.ui.theme.CovenBookingDeskColors
import zed.rainxch.octoberminichallenges.ui.theme.cinzelFontFamily

@Composable
fun CovenBookingDeskButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = CutCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = CovenBookingDeskColors.frameInactive
        ),
        modifier = modifier
            .fillMaxWidth()
            .drawWithContent {
                drawContent()

                drawRect(
                    color = CovenBookingDeskColors.outlineActive,
                    style = Stroke(width = 2f),
                    topLeft = Offset(x = 5f, y = 15f),
                    size = Size(width = size.width - 10f, height = size.height - 30f)
                )
            }
    ) {
        Text(
            text = title.uppercase(),
            fontSize = 21.sp,
            fontFamily = cinzelFontFamily,
            fontWeight = FontWeight.Bold,
            color = CovenBookingDeskColors.textPrimary
        )
    }
}

@Preview
@Composable
private fun CovenBookingDeskButtonPreview() {
    CovenBookingDeskButton(
        title = "Change date",
        onClick = {

        }
    )
}
