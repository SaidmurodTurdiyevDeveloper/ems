package uzb.smt.presenter.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uzb.smt.presenter.screens.chat_details.ChatDetailsScreen
import uzb.smt.presenter.screens.chat_details.ChatDetailsViewModel
import uzb.smt.presenter.screens.login.LoginScreen
import uzb.smt.presenter.screens.login.LoginViewModel
import uzb.smt.presenter.screens.subject_details.SubjectDetailsScreen
import uzb.smt.presenter.screens.subject_details.SubjectDetailsViewModel
import uzb.smt.presenter.screens.tab.MainTabScreen
import uzb.smt.presenter.theme.EMSTheme

@Composable
fun NavigationScreen() {
    val navController: NavHostController = rememberNavController()
    LaunchedEffect(key1 = Unit) {
        AppNavigatorImpl.navigator.onEach {
            it.invoke(navController)
        }.launchIn(this)
    }
    EMSTheme {

        NavHost(
            navController = navController, startDestination = AppScreens.LoginScreen.route
        ) {
            composable(AppScreens.SplashScreen.route) {

            }
            composable(AppScreens.LoginScreen.route) {
                val viewmodel = hiltViewModel<LoginViewModel>()
                val state by viewmodel.uiState.collectAsState()
                LoginScreen(
                    state = state, onAction = viewmodel::onAction
                )
            }
            composable(route = AppScreens.AppMainTabScreen.route) {
                MainTabScreen()
            }
            composable(
                route = AppScreens.ChatDetails().route, arguments = listOf(
                    navArgument("chatId") {
                        type = NavType.StringType
                    })
            ) {
                val viewmodel = hiltViewModel<ChatDetailsViewModel>()
                val state by viewmodel.uiState.collectAsState()
                ChatDetailsScreen(
                    state = state, onAction = viewmodel::onAction
                )
            }
            composable(
                route = AppScreens.SubjectDetails().route,
                arguments = listOf(
                    navArgument("subjectId") {
                        type = NavType.StringType
                    })
            ) {
                val viewmodel = hiltViewModel<SubjectDetailsViewModel>()
                val state by viewmodel.uiState.collectAsState()
                SubjectDetailsScreen(
                    state = state, onAction = viewmodel::onAction
                )
            }
        }
    }
}