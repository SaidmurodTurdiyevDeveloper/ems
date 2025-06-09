package uzb.smt.presenter.screens.tab.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import uzb.smt.presenter.navigator.TabScreen
import uzb.smt.presenter.theme.DarkPurple

@Composable
internal fun BottomNavigation(
    modifier: Modifier = Modifier,
    tabNavigator: NavHostController
) {
    val navBackStackEntry = tabNavigator.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    Card(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(horizontal = 12.dp, vertical = 4.dp),
        shape = RoundedCornerShape(38.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp )
                .offset(y = 3.dp)
                .background(Color.White, shape = RoundedCornerShape(38.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TabNavigationItem(
                selected = currentRoute == TabScreen.SubjectTab.route,
                tabScreen = TabScreen.SubjectTab,
                onClick = {
                    tabNavigator.navigate(TabScreen.SubjectTab.route) {
                        popUpTo(tabNavigator.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            TabNavigationItem(
                selected = currentRoute == TabScreen.LessonScheduleTab.route,
                tabScreen = TabScreen.LessonScheduleTab,
                onClick = {
                    tabNavigator.navigate(TabScreen.LessonScheduleTab.route) {
                        popUpTo(tabNavigator.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            TabNavigationItem(
                selected = currentRoute == TabScreen.MainTab.route,
                tabScreen = TabScreen.MainTab,
                onClick = {
                    tabNavigator.navigate(TabScreen.MainTab.route) {
                        popUpTo(tabNavigator.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            TabNavigationItem(
                selected = currentRoute == TabScreen.ChatTab.route,
                tabScreen = TabScreen.ChatTab,
                onClick = {
                    tabNavigator.navigate(TabScreen.ChatTab.route) {
                        popUpTo(tabNavigator.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            TabNavigationItem(
                selected = currentRoute == TabScreen.UseFullTab.route,
                tabScreen = TabScreen.UseFullTab,
                onClick = {
                    tabNavigator.navigate(TabScreen.UseFullTab.route) {
                        popUpTo(tabNavigator.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
private fun RowScope.TabNavigationItem(
    selected: Boolean = false,
    tabScreen: TabScreen,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(
                color = if (selected) DarkPurple else Color.Transparent
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                onClick = onClick
            )
            .padding(vertical = 4.dp), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = if (selected) painterResource(id = tabScreen.selectedIcon) else painterResource(id = tabScreen.icon),
            contentDescription = stringResource(tabScreen.title),
            tint = if (selected) Color.White else Color.Unspecified
        )
    }
}

@Preview
@Composable
private fun BottomNavigationPrev() {

}