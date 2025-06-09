package uzb.smt.presenter.screens.home_tab.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import uzb.smt.domen.model.UserData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.DarkBlue
import uzb.smt.presenter.theme.LightDarkBlue
import uzb.smt.presenter.theme.Montserrat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeToolBar(
    modifier: Modifier = Modifier,
    user: UserData?,
    isExistNotification: Boolean,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val expandedAppBarHeight = 175.dp

    val headerTranslation = (expandedAppBarHeight / 2)
    val scrollState = scrollBehavior.state
    val appBarExpanded by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction >= 0.5f }
    }
    val colorChange by remember {
        derivedStateOf { scrollBehavior.state.collapsedFraction >= 0.95f }
    }
    val toolBarColor by animateColorAsState(if (colorChange) LightDarkBlue else DarkBlue)

    val cornerRadius by animateDpAsState(if (appBarExpanded) 16.dp else 0.dp)

    Column(
        modifier = modifier
            .zIndex(0f)
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(listOf(DarkBlue, toolBarColor)),
                RoundedCornerShape(
                    bottomStart = cornerRadius,
                    bottomEnd = cornerRadius
                )
            )
    ) {
        Row(
            modifier = Modifier
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(horizontal = 8.dp, vertical = 8.dp), verticalAlignment = Alignment.Top
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.img_avatar),
                contentDescription = "img avataer"
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 11.dp)
                    .height(50.dp)
                    .padding(vertical = 2.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(uzb.smt.common.R.string.wlcome),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.W700,
                        fontFamily = Montserrat
                    )
                )
                Text(
                    text = user?.name ?: "",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        color = Color.White.copy(0.6f),
                        fontWeight = FontWeight.W600,
                        fontFamily = Montserrat
                    )
                )
            }
            IconButton(
                modifier = Modifier.size(41.dp),
                onClick = {}) {
                Image(
                    painter = if (!isExistNotification) painterResource(R.drawable.ic_notification) else painterResource(R.drawable.ic_notification_exist),
                    contentDescription = "notification"
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
                                    color = Color.White.copy(0.38f),
                                    shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp)
                                )
                                .width(208.dp)
                                .padding(12.dp),
                            text = stringResource(uzb.smt.common.R.string.difficult_message),
                            style = TextStyle(
                                fontSize = 10.sp,
                                lineHeight = 12.sp,
                                color = Color.White,
                                fontWeight = FontWeight.W600,
                                fontFamily = Montserrat
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
