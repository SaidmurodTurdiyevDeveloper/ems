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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        topBar = {
            SubjectToolBar(
                scrollBehavior = scrollBehavior,
                onAction = onAction
            )
        }) { innerPadding ->
        ScrollContent(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()
                .padding(innerPadding),
            state = state,
            onAction = onAction,
            scrollBehavior = scrollBehavior
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SubjectToolBar(
    modifier: Modifier = Modifier,
    onAction: (SubjectIntent) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val expandedAppBarHeight = 175.dp
    val appBarExpanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction < 0.9f }
    }
    val headerTranslation = (expandedAppBarHeight / 2)
    val scrollState = scrollBehavior.state

    Box(
        modifier = modifier
            .zIndex(0f)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AnimatedVisibility(
                visible = !appBarExpanded,
                enter = fadeIn(animationSpec = tween()),
                exit = fadeOut(animationSpec = tween())
            ) {
                Text(
                    text = stringResource(commonR.string.subjects),
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.W700,
                        fontFamily = Montserrat
                    )
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(
                modifier = Modifier.size(41.dp), onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_news_black), contentDescription = "notification"
                )
            }
            IconButton(
                modifier = Modifier.size(41.dp), onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_moon_black), contentDescription = "day night"
                )
            }
        }
        TopAppBar(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(top = 51.dp, bottom = 8.dp),
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            translationY = scrollState.collapsedFraction * headerTranslation.toPx()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_subject),
                        contentDescription = "img subject",
                        modifier = Modifier
                            .height(177.dp),
                        contentScale = ContentScale.FillHeight
                    )
                }
            },
            expandedHeight = 177.dp,
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            windowInsets = WindowInsets(0),
            scrollBehavior = scrollBehavior
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScrollContent(
    modifier: Modifier = Modifier,
    state: SubjectState,
    onAction: (SubjectIntent) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val appBarExpanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction < 0.9f }
    }

    val cornerRadius by animateDpAsState(if (appBarExpanded) 16.dp else 0.dp)
    val height by animateDpAsState(if (appBarExpanded) 52.dp else 0.dp)

    LazyVerticalGrid(
        modifier = modifier
            .drawBehind {
                val shadowColor = Color.Black.copy(alpha = 0.25f)
                val paint = Paint().asFrameworkPaint().apply {
                    color = android.graphics.Color.TRANSPARENT
                    setShadowLayer(10.dp.toPx(), 0f, (-1).dp.toPx(), shadowColor.toArgb())
                }

                drawIntoCanvas {
                    it.nativeCanvas.drawRoundRect(0f, 0f, size.width, size.height / 2, cornerRadius.toPx(), cornerRadius.toPx(), paint)
                }
            }
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius)
            )
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues( bottom = 120.dp, start = 8.dp, end = 8.dp),
        columns = GridCells.Fixed(2)
    ) {
        item(
            key = "header",
            span = {
                GridItemSpan(2)
            }
        ) {
            if (height > 0.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 22.dp),
                        text = stringResource(commonR.string.subjects),
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 24.sp,
                            color = Color(0xFF000000),
                            fontWeight = FontWeight.W700,
                            fontFamily = Montserrat
                        )
                    )
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
            Spacer(Modifier.height(16.dp))
        }
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

