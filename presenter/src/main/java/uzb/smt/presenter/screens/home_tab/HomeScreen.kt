package uzb.smt.presenter.screens.home_tab

import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import uzb.smt.presenter.R
import uzb.smt.presenter.screens.home_tab.components.CalendarScreen
import uzb.smt.presenter.screens.home_tab.components.CurrentLessonItem
import uzb.smt.presenter.screens.home_tab.components.ScrollViewDrug
import uzb.smt.presenter.screens.home_tab.components.SubjectItem
import uzb.smt.presenter.screens.home_tab.components.WeatherScreen
import uzb.smt.presenter.theme.MainToolbarBgColor
import uzb.smt.presenter.theme.MainToolbarBgColor2
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    state: HomeState,
    onAction: (HomeIntent) -> Unit
) {

    val context = LocalContext.current
    val isDarkTheme = isSystemInDarkTheme()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val appBarExpanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction < 0.9f }
    }
    val toolBarColor by animateColorAsState(if (appBarExpanded) MainToolbarBgColor else MainToolbarBgColor2)
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = if (isDarkTheme) {
                SystemBarStyle.light(
                    scrim = android.graphics.Color.TRANSPARENT, darkScrim = android.graphics.Color.TRANSPARENT
                )
            } else {
                SystemBarStyle.dark(
                    scrim = android.graphics.Color.TRANSPARENT
                )
            }
        )
    }
    val lifecycle = LocalLifecycleOwner.current
    DisposableEffect(lifecycle.lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                (context as ComponentActivity).enableEdgeToEdge(
                    statusBarStyle = if (isDarkTheme) {
                        SystemBarStyle.light(
                            scrim = android.graphics.Color.TRANSPARENT, darkScrim = android.graphics.Color.TRANSPARENT
                        )
                    } else {
                        SystemBarStyle.dark(
                            scrim = android.graphics.Color.TRANSPARENT
                        )
                    }
                )
            }
            if (event == Lifecycle.Event.ON_PAUSE) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    (context as ComponentActivity).window.insetsController?.setSystemBarsAppearance(
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                    )
                } else {
                    val decorView = (context as ComponentActivity).window.decorView
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            }
        }
        lifecycle.lifecycle.addObserver(observer)
        onDispose {
            lifecycle.lifecycle.removeObserver(observer)
        }
    }

    val cornerRadius by animateDpAsState(if (appBarExpanded) 16.dp else 0.dp)
    Scaffold(
        contentWindowInsets = WindowInsets(0),
        topBar = {
            MainToolBar(
                scrollBehavior = scrollBehavior,
                toolBarColor = toolBarColor
            )
        }) { innerPadding ->
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
                    .background(MainToolbarBgColor)
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
                        color = Color.White,
                        shape = RoundedCornerShape(
                            topStart = cornerRadius, topEnd = cornerRadius
                        )
                    )) {
                ScrollViewDrug(scrollBehavior = scrollBehavior)
                ScrollContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    state = state,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainToolBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    toolBarColor: Color
) {
    val expandedAppBarHeight = 175.dp

    val headerTranslation = (expandedAppBarHeight / 2)
    val scrollState = scrollBehavior.state

    Column(
        modifier = modifier
            .zIndex(0f)
            .fillMaxWidth()
            .background(toolBarColor)
    ) {
        Row(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.Top
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape), painter = painterResource(R.drawable.img_avatar), contentDescription = "img avataer"
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 11.dp)
                    .height(50.dp)
                    .padding(vertical = 2.dp)
                    .weight(1f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Xush kelibsiz !", style = TextStyle(
                        fontSize = 24.sp, lineHeight = 24.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W700, fontFamily = Montserrat
                    )
                )
                Text(
                    text = "O’rinboyev Yusufbek", style = TextStyle(
                        fontSize = 14.sp, lineHeight = 14.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                    )
                )
            }
            IconButton(
                modifier = Modifier.size(41.dp), onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_news), contentDescription = "notification"
                )
            }
            IconButton(
                modifier = Modifier.size(41.dp), onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.ic_moon), contentDescription = "day night"
                )
            }
        }
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            translationY = scrollState.collapsedFraction * headerTranslation.toPx()
                        }) {
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp), verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            CalendarScreen()
                            WeatherScreen(degree = "22°")
                        }
                        Text(
                            modifier = Modifier
                                .background(
                                    color = Color(0x61FFFFFF), shape = RoundedCornerShape(14.dp)
                                )
                                .width(208.dp)
                                .padding(12.dp), text = "Qiyinchiliklar – faqatgina sinov, sen esa undan kuchliroqsan", style = TextStyle(
                                fontSize = 10.sp, lineHeight = 12.sp, color = Color(0xFFFFFFFF), fontWeight = FontWeight.W600, fontFamily = Montserrat
                            )
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.img_toolbar),
                        contentDescription = "img avatar",
                        modifier = Modifier
                            .width(144.dp)
                            .height(132.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = (-26).dp, y = (-23).dp)
                    )
                }
            }, colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent, scrolledContainerColor = Color.Transparent
            ), expandedHeight = expandedAppBarHeight, windowInsets = WindowInsets(0), scrollBehavior = scrollBehavior
        )
    }
}


@Composable
private fun ScrollContent(
    modifier: Modifier = Modifier,
    state: HomeState
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 120.dp)
    ) {
        if (state.currentLesson != null) {
            item(key = "currentLesson") {
                CurrentLessonItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(161.dp)
                        .padding(horizontal = 8.dp),
                    item = state.currentLesson
                )
            }
        }
        if (state.tasks.isNotEmpty()) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = stringResource(commonR.string.tasks),
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 20.sp,
                            color = Color(0xFF333438),
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = stringResource(commonR.string.all),
                            style = TextStyle(
                                fontSize = 16.sp, lineHeight = 16.sp, color = Color(0xFF1495FF), fontWeight = FontWeight.W500, fontFamily = Montserrat
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .height(188.dp)
                        .padding(horizontal = 16.dp)
                        .background(
                            color = Color(0xFFF5F5F5),
                            shape = RoundedCornerShape(20.dp)
                        )
                ) {

                }
            }
        }
        if (state.subjects.isNotEmpty()) {
            item {
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
                            color = Color(0xFF333438),
                            fontWeight = FontWeight.W600,
                            fontFamily = Montserrat
                        )
                    )
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = stringResource(commonR.string.all),
                            style = TextStyle(
                                fontSize = 16.sp, lineHeight = 16.sp, color = Color(0xFF1495FF), fontWeight = FontWeight.W500, fontFamily = Montserrat
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
                    items(state.subjects) {
                        SubjectItem(
                            modifier = Modifier,
                            subjectScoreData = it
                        )
                    }
                }
            }
        }
    }
}

