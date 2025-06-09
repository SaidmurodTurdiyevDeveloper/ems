package uzb.smt.presenter.screens.home_tab

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import uzb.smt.presenter.screens.home_tab.components.CurrentLessonItem
import uzb.smt.presenter.screens.home_tab.components.HomeToolBar
import uzb.smt.presenter.screens.home_tab.components.JadidItem
import uzb.smt.presenter.screens.home_tab.components.ScrollViewDrug
import uzb.smt.presenter.screens.home_tab.components.SubjectItem
import uzb.smt.presenter.screens.home_tab.components.SubjectTaskItem
import uzb.smt.presenter.theme.BlackTextSecond
import uzb.smt.presenter.theme.DarkBlue
import uzb.smt.presenter.theme.LightBlueThird
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.WhiteScreen
import uzb.smt.common.R as commonR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    state: HomeState,
    onAction: (HomeIntent) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val appBarExpanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction < 0.5f }
    }

    val cornerRadius by animateDpAsState(if (appBarExpanded) 16.dp else 0.dp)
    Scaffold(
        contentWindowInsets = WindowInsets(0),
        topBar = {
            HomeToolBar(
                scrollBehavior = scrollBehavior,
                user = state.user,
                isExistNotification = state.existNotification
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .background(DarkBlue)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        val shadowColor = Color.Black.copy(alpha = 0.25f)
                        val paint = Paint().asFrameworkPaint().apply {
                            color = android.graphics.Color.TRANSPARENT
                            setShadowLayer(
                                4.dp.toPx(), 0f, (-1).dp.toPx(), shadowColor.toArgb()
                            )
                        }

                        drawIntoCanvas {
                            it.nativeCanvas.drawRoundRect(
                                0f, 0f, size.width, size.height / 2, cornerRadius.toPx(), cornerRadius.toPx(), paint
                            )
                        }
                    }
                    .background(
                        color = WhiteScreen,
                        shape = RoundedCornerShape(
                            topStart = cornerRadius,
                            topEnd = cornerRadius
                        )
                    )
            ) {
                HomeScreenContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    state = state,
                    onAction = onAction
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeState,
    onAction: (HomeIntent) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 120.dp)
    ) {
        item(key = "scrol drug") {
            ScrollViewDrug(modifier = Modifier)
        }
        if (state.currentLesson != null) {
            item(key = "currentLesson") {
                CurrentLessonItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    item = state.currentLesson
                )
            }
        }
        if (state.tasks.isNotEmpty()) {
            item(key = "tasks") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(commonR.string.tasks),
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = BlackTextSecond,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.tasks) {
                        SubjectTaskItem(
                            task = it,
                            onClick = { },
                            onDone = { }
                        )
                    }
                }
            }
        }
        if (state.subjectScores.isNotEmpty()) {
            item(key = "subject scores") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(commonR.string.scores),
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = BlackTextSecond,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {
                            onAction(HomeIntent.AllScores)
                        }
                    ) {
                        Text(
                            text = stringResource(commonR.string.all),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                color = LightBlueThird,
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 7.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(state.subjectScores) {
                        SubjectItem(
                            modifier = Modifier,
                            subjectScoreData = it
                        ) {
                            onAction(HomeIntent.OpenSubjectDetailScreen(it.subjectId))
                        }
                    }
                }
            }
        }
        if (state.jadids.isNotEmpty()) {
            item(key = "jadids") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(commonR.string.jadids),
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = BlackTextSecond,
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {
                            onAction(HomeIntent.AllJadids)
                        }
                    ) {
                        Text(
                            text = stringResource(commonR.string.all),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                color = LightBlueThird,
                                fontWeight = FontWeight.W500,
                                fontFamily = Montserrat
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(vertical = 7.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(state.jadids) {
                        JadidItem(
                            modifier = Modifier,
                            item = it
                        ) {

                        }
                    }
                }
            }
        }
    }
}

