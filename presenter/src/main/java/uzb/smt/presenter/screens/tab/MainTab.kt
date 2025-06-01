package uzb.smt.presenter.screens.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uzb.smt.presenter.navigator.TabScreen
import uzb.smt.presenter.screens.chat_tab.ChatScreen
import uzb.smt.presenter.screens.chat_tab.ChatViewModel
import uzb.smt.presenter.screens.home_tab.HomeScreen
import uzb.smt.presenter.screens.home_tab.HomeViewModel
import uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleScreen
import uzb.smt.presenter.screens.lesson_schedule_tab.LessonScheduleViewModel
import uzb.smt.presenter.screens.subject_tab.SubjectScreen
import uzb.smt.presenter.screens.subject_tab.SubjectViewModel
import uzb.smt.presenter.screens.tab.components.BottomNavigation
import uzb.smt.presenter.screens.usefull_tab.UseFullScreen
import uzb.smt.presenter.screens.usefull_tab.UseFullViewModel


@Composable
internal fun MainTabScreen() {
    val tabNavigator = rememberNavController()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            tabNavigator,
            startDestination = TabScreen.MainTab.route,
            Modifier.fillMaxSize()
        ) {
            composable(route = TabScreen.SubjectTab.route) {
                val viewmodel = hiltViewModel<SubjectViewModel>()
                val state by viewmodel.uiState.collectAsState()
                SubjectScreen(state, onAction = viewmodel::onAction)
            }
            composable(route = TabScreen.LessonScheduleTab.route) {
                val viewmodel = hiltViewModel<LessonScheduleViewModel>()
                val state by viewmodel.uiState.collectAsState()
                LessonScheduleScreen(state, onAction = viewmodel::onAction)
            }
            composable(route = TabScreen.MainTab.route) {
                val viewmodel = hiltViewModel<HomeViewModel>()
                val state by viewmodel.uiState.collectAsState()
                HomeScreen(
                    state = state,
                    onAction = viewmodel::onAction
                )
            }
            composable(route = TabScreen.ChatTab.route) {
                val viewmodel = hiltViewModel<ChatViewModel>()
                val state by viewmodel.uiState.collectAsState()
                ChatScreen(
                    state = state,
                    onAction = viewmodel::onAction
                )
            }
            composable(route = TabScreen.UseFullTab.route) {
                val viewmodel = hiltViewModel<UseFullViewModel>()
                val state by viewmodel.uiState.collectAsState()
                UseFullScreen(
                    state = state,
                    onAction = viewmodel::onAction
                )
            }
        }
        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            tabNavigator = tabNavigator
        )
    }
}

@Preview
@Composable
private fun MainTabContentPrev() {
    MainTabScreen()
}


