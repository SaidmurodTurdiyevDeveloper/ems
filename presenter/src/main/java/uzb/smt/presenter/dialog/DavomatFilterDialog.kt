package uzb.smt.presenter.dialog

import android.widget.RadioGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uzb.smt.presenter.screens.home_tab.components.ScrollViewDrug


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DavomatFilterDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,

        dragHandle = {
            ScrollViewDrug()
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.navigationBars)
                .padding(top = 32.dp, bottom = 24.dp, start = 24.dp)
        ) {
            Row (modifier = ){

            }
        }
    }

}