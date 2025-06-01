package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uzb.smt.presenter.theme.MainToolbarBgColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ScrollViewDrug(
    modifier: Modifier = Modifier, scrollBehavior: TopAppBarScrollBehavior
) {
    val coroutineScope = rememberCoroutineScope()
    val dragState = remember { mutableFloatStateOf(0f) }

    Column(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGestures(onDragEnd = {
                    coroutineScope.launch {
                        val velocity = Velocity(0f, dragState.floatValue * 2)
                        scrollBehavior.nestedScrollConnection.onPostFling(
                            Velocity.Zero, velocity
                        )
                    }
                }, onDrag = { change, dragAmount ->
                    change.consume()
                    dragState.floatValue = dragAmount.y
                    val scrollDelta = Offset(0f, dragAmount.y * 0.6f)
                    val preConsumed = scrollBehavior.nestedScrollConnection.onPreScroll(
                        scrollDelta, NestedScrollSource.UserInput
                    )
                    val remaining = scrollDelta - preConsumed
                    scrollBehavior.nestedScrollConnection.onPostScroll(
                        consumed = preConsumed, available = remaining, NestedScrollSource.UserInput
                    )
                })
            }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .padding(top = 12.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(width = 85.dp, height = 3.dp)
                    .background(
                        color = MainToolbarBgColor, shape = RoundedCornerShape(3.dp)
                    )
            )
        }
    }
}