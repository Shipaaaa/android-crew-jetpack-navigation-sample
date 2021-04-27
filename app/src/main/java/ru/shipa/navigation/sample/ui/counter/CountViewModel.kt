package ru.shipa.navigation.sample.ui.counter

import androidx.lifecycle.distinctUntilChanged
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.RootNavGraphDirections
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel

class CountViewModel : BaseViewModel<CounterViewState>() {

    val counterState = liveState.distinctUntilChanged()

    fun setCount(count: Int) {
        updateState(
            CounterViewState(
                if (count < 0) 1 else count
            )
        )
    }

    fun onCountButtonClick() {
        navigateTo(
            CounterFragmentDirections.toNextCounterFragment(state.counter + 1)
        )
    }

    fun onBackButtonClick() {
        navigateBackTo(R.id.mainFragment, inclusive = false)
    }

    fun onMainButtonClick() {
        navigateTo(RootNavGraphDirections.toMain())
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
