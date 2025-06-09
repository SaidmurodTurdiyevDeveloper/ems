package uzb.smt.presenter.screens.calculator

import dagger.hilt.android.lifecycle.HiltViewModel
import uzb.smt.presenter.navigator.AppNavigatorImpl
import uzb.smt.presenter.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
internal class CalculatorViewModel @Inject constructor(appNavigator: AppNavigatorImpl) : BaseViewModel<
        CalculatorState, CalculatorIntent>(
    initializeData = CalculatorState(),
    appNavigator = appNavigator
) {

    override fun onAction(intent: CalculatorIntent) {
        when (intent) {
            is CalculatorIntent.Back -> back()
            is CalculatorIntent.OnClickNumber -> clickNumber(intent.number)
            is CalculatorIntent.OnClickOperator -> clickOperator(intent.operator)
        }
    }

    private fun clickNumber(number: String) {
        val text = state.text + number
        update(state.copy(text = text))
    }

    private fun clickOperator(operator: CalculatorClickOperator) {
        if (state.text.isBlank()) return
        when (operator) {
            CalculatorClickOperator.PLUS -> {
                val text = state.text + " + "
                update(state.copy(text = text))
            }

            CalculatorClickOperator.MINUS -> {
                val text = state.text + " - "
                update(state.copy(text = text))
            }

            CalculatorClickOperator.MULTIPLY -> {
                val text = state.text + " * "
                update(state.copy(text = text))
            }

            CalculatorClickOperator.DIVIDE -> {
                val text = state.text + " / "
                update(state.copy(text = text))
            }

            CalculatorClickOperator.SIN -> {
                val text = state.text + " sin"
                update(state.copy(text = text))
            }

            CalculatorClickOperator.COS -> {
                val text = state.text + " cos"
                update(state.copy(text = text))
            }

            CalculatorClickOperator.TAN -> {
                val text = state.text + " tan"
                update(state.copy(text = text))
            }

            CalculatorClickOperator.FLOAT -> {
                val text = state.text + " ."
                update(state.copy(text = text))
            }

            CalculatorClickOperator.POWER -> {
                val text = state.text + " ^"
                update(state.copy(text = text))
            }
        }
    }
}