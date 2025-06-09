package uzb.smt.presenter.screens.calculator

internal sealed interface CalculatorIntent {
    data object Back: CalculatorIntent
    data class OnClickNumber(val number: String) : CalculatorIntent
    data class OnClickOperator(val operator: CalculatorClickOperator) : CalculatorIntent
}