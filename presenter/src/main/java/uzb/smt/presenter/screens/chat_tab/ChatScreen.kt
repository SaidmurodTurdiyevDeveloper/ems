package uzb.smt.presenter.screens.chat_tab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import uzb.smt.domen.model.ChatData
import uzb.smt.presenter.R
import uzb.smt.presenter.theme.Montserrat
import uzb.smt.common.R as commonR


@Composable
internal fun ChatScreen(
    state: ChatState, onAction: (ChatIntent) -> Unit
) {
    val pager = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(commonR.string.chat),
                style = TextStyle(
                    fontSize = 24.sp, lineHeight = 26.sp, color = Color(0xFF3A405A), fontWeight = FontWeight.W700, fontFamily = Montserrat
                )
            )
            Spacer(Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.size(8.dp))
        TabRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp), selectedTabIndex = pager.currentPage, divider = {}, indicator = { tabPositions ->
                if (pager.currentPage < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier
                            .width(130.dp)
                            .tabIndicatorOffset(tabPositions[pager.currentPage]), color = Color(0xFF0077FF)
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
                    text = stringResource(commonR.string.private_chat), style = TextStyle(
                        fontSize = 14.sp, lineHeight = 18.sp, color = if (pager.currentPage == 0) Color(0xFF0077FF)
                        else Color(0xFF3A405A), fontFamily = Montserrat, fontWeight = FontWeight.W600
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
                        color = if (pager.currentPage == 1) Color(0xFF0077FF) else Color(0xFF3A405A),
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
                0 -> {
                    ChatListScreen(
                        list = state.privateChats, onAction = onAction
                    )
                }

                1 -> {
                    ChatListScreen(
                        list = state.groupChats, onAction = onAction
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListScreen(
    list: List<ChatData>, onAction: (ChatIntent) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { index, item ->
            ChatItem(
                image = item.image, name = item.name, description = item.description, lastDate = item.lastMessageSeenDate, read = item.lastMessageSeen, isLast = index == list.lastIndex
            ) {
                onAction(ChatIntent.OpenChat(item.id))
            }
        }
    }
}


@Composable
internal fun ChatItem(
    modifier: Modifier = Modifier, image: String, name: String, description: String, lastDate: String, read: Boolean, isLast: Boolean, onAction: () -> Unit
) {
    val time = lastDate.split(" ")[1]
    Card(
        modifier = modifier.fillMaxWidth(), onClick = onAction, colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 12.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 14.dp), verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_avatar), contentDescription = "avatar", modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                )
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                Column(
                    modifier = Modifier
                        .height(45.dp)
                        .weight(1f), verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name, maxLines = 1, overflow = TextOverflow.Ellipsis, style = TextStyle(
                            fontSize = 16.sp, lineHeight = 20.sp, color = Color(0xFF1F2937), fontWeight = FontWeight.W600, fontFamily = Montserrat
                        )
                    )
                    Text(
                        text = description, maxLines = 1, overflow = TextOverflow.Ellipsis, style = TextStyle(
                            fontSize = 12.sp, lineHeight = 16.sp, color = Color(0xFF1F2937), fontWeight = FontWeight.W600, fontFamily = Montserrat
                        )
                    )
                }
                if (read) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_seen), contentDescription = "arrow right", tint = Color(0xFF00226B), modifier = Modifier.padding(end = 10.dp)
                    )
                }

                Text(
                    text = time, maxLines = 1, overflow = TextOverflow.Ellipsis, style = TextStyle(
                        fontSize = 12.sp, lineHeight = 14.sp, color = Color(0xFF3A405A), fontWeight = FontWeight.W600, fontFamily = Montserrat
                    )
                )
            }
            if (!isLast) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFD9D9D9)
                )
            }
        }
    }
}