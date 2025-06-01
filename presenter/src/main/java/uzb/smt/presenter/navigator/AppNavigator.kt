package uzb.smt.presenter.navigator

internal interface AppNavigator {
    suspend fun navigate(screen: Screen)
    suspend fun navigateWithOutBack(screen: Screen, currentScreen: Screen)
    suspend fun back()
}