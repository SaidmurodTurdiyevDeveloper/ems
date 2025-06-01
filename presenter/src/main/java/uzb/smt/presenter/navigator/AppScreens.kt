package uzb.smt.presenter.navigator

internal sealed class AppScreens(override val route: String) : Screen(route = route) {
    data object SplashScreen : AppScreens(route = "SplashScreen")
    data object LoginScreen : AppScreens(route = "LoginScreen")
    data class ChatDetails(val chatId: String?=null) : AppScreens(route = if(chatId == null) "chatDetails/{chatId}" else "chatDetails/$chatId")
    data object AppMainTabScreen : AppScreens(route = "AppTabScreen")
}