package cz.freego.tutorial.core.design.compose.button

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.freego.tutorial.core.design.theme.phone.SpaceXplorerTheme

@Composable
fun GotoSpecialButton(
    modifier: Modifier = Modifier.fillMaxHeight(),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        shape = RoundedCornerShape(12.dp), // Zaoblené rohy
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Ikona šipky doprava
            contentDescription = "Next",
            tint = MaterialTheme.colorScheme.onPrimary // Barva ikony
        )
    }
}

@Preview
@Composable
private fun GotoSpecialButtonPreview() {
    SpaceXplorerTheme {
        Surface {
            GotoSpecialButton (
                modifier = Modifier.height(96.dp),
                onClick = {},
            )
        }
    }
}