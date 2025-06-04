package uzb.smt.presenter.screens.subject_tab

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import uzb.smt.presenter.R
import uzb.smt.presenter.screens.subject_tab.component.FavouriteSubjectItem
import uzb.smt.presenter.screens.subject_tab.component.SubjectItem
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SubjectScreen(
    state: SubjectState,
    onAction: (SubjectIntent) -> Unit
) {

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        topBar = {
            SubjectToolBar()
        }) { innerPadding ->
        ScrollContent(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()
                .padding(innerPadding),
            state = state,
            onAction = onAction
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectToolBar(
    modifier: Modifier = Modifier
) {


    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        shape = RoundedCornerShape(
            bottomStart = 15.dp,
            bottomEnd = 15.dp
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(start = 16.dp, end = 4.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.subjects),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    color = Color(0xFF2B343E),
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))

            IconButton(
                modifier = Modifier.size(36.dp),
                onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "notification",
                    tint = Color(0xFF2B343E)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScrollContent(
    modifier: Modifier = Modifier,
    state: SubjectState,
    onAction: (SubjectIntent) -> Unit,
) {


    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 120.dp, start = 8.dp, end = 8.dp, top = 18.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(
            count = state.favourites.size,
            span = {
                GridItemSpan(1)
            }
        ) { index ->
            FavouriteSubjectItem(
                subjectData = state.favourites[index],
                isLeft = index % 2 == 0
            )
        }
        if (state.favourites.isNotEmpty()) {
            item(key = "Space") {
                Spacer(Modifier.height(4.dp))
            }
        }

        items(
            items = state.subjects,
            span = {
                GridItemSpan(2)
            }
        ) {
            SubjectItem(
                modifier = Modifier
                    .fillMaxWidth(),
                subjectData = it
            )
        }
    }
}

