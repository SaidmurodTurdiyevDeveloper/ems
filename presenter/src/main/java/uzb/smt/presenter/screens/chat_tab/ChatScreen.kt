package uzb.smt.presenter.screens.chat_tab

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import uzb.smt.presenter.screens.chat_tab.component.ChatListScreen
import uzb.smt.presenter.theme.Blue
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.presenter.theme.Purple
import uzb.smt.presenter.theme.WhiteScreenFourth
import uzb.smt.common.R as commonR


@Composable
internal fun ChatScreen(
    state: ChatState, onAction: (ChatIntent) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        (context as ComponentActivity).enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT
            )
        )
    }
    val pager = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = WhiteScreenFourth)
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.chat),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 26.sp,
                    color = Purple,
                    fontWeight = FontWeight.W700,
                    fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.size(8.dp))
        TabRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            selectedTabIndex = pager.currentPage,
            divider = {},
            indicator = { tabPositions ->
                if (pager.currentPage < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier
                            .width(130.dp)
                            .tabIndicatorOffset(tabPositions[pager.currentPage]),
                        color = Blue
                    )
                }
            }, containerColor = Color.Transparent
        ) {

            Tab(modifier = Modifier.weight(1f), selected = pager.currentPage == 0, onClick = {
                scope.launch {
                    pager.animateScrollToPage(0)
                }
            }, text = {
                Text(
                    text = stringResource(commonR.string.private_chat),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = if (pager.currentPage == 0) Blue
                        else Purple,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W600
                    )
                )
            })

            Tab(modifier = Modifier.weight(1f), selected = pager.currentPage == 1, onClick = {
                scope.launch {
                    pager.animateScrollToPage(1)
                }
            }, text = {
                Text(
                    text = stringResource(commonR.string.group),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        color = if (pager.currentPage == 1) Blue else Purple,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W600
                    )
                )
            })
        }
        HorizontalPager(
            state = pager
        ) {
            when (it) {
                0 -> ChatListScreen(list = state.privateChats, onAction = onAction)

                1 -> ChatListScreen(list = state.groupChats, onAction = onAction)
            }
        }
    }
}

@Preview
@Composable
private fun ChatScreenPrev() {
    ChatScreen(
        state = ChatState()
    ) {}
}


