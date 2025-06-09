package uzb.smt.presenter.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uzb.smt.presenter.navigator.AppNavigator
import uzb.smt.presenter.navigator.Screen

internal abstract class BaseViewModel<State, Intent>(initializeData: State, private val appNavigator: AppNavigator) : ViewModel() {
    protected var _uiState = MutableStateFlow(initializeData)
    val uiState = _uiState.asStateFlow()
    protected val state get() = uiState.value

    abstract fun onAction(intent: Intent)

    protected fun back() {
        viewModelScope.launch {
            appNavigator.back()
        }
    }


    protected fun update(newState: State) {
        _uiState.update { newState }
    }

    protected fun navigate(screen: Screen) {
        viewModelScope.launch {
            appNavigator.navigate(screen)
        }
    }

    protected fun navigateWithoutBack(screen: Screen,currentScreen: Screen) {
        viewModelScope.launch {
            appNavigator.navigateWithOutBack(screen,currentScreen)
        }
    }
}