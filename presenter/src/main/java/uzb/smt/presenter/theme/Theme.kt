package uzb.smt.presenter.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
internal fun EMSTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(background = Color.White),
        typography = MaterialTheme.typography.copy(),
        content = content
    )
}