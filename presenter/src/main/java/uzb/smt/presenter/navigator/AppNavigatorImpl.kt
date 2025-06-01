package uzb.smt.presenter.navigator

import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
internal class AppNavigatorImpl @Inject constructor() : AppNavigator {
    companion object {
        val navigator = MutableSharedFlow<NavArgs>()
    }

    private suspend fun navigate(args: NavArgs) {
        navigator.emit(args)
    }

    override suspend fun navigate(screen: Screen) = navigate {
        navigate(screen.route)
    }

    override suspend fun navigateWithOutBack(
        screen: Screen,
        currentScreen: Screen
    ) = navigate {
        navigate(screen.route) {
            popUpTo(currentScreen.route) {
                inclusive = true
            }
        }
    }

    override suspend fun back() = navigate {
        popBackStack()
    }
}

internal typealias NavArgs = NavHostController.() -> Unit