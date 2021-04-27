package ru.shipa.navigation.sample.ui.home

import androidx.lifecycle.distinctUntilChanged
import ru.shipa.navigation.sample.RootNavGraphDirections
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel

class HomeViewModel : BaseViewModel<HomeViewState>() {

    init {
        updateState(HomeViewState("This is home Fragment"))
    }

    val textState = liveState.distinctUntilChanged()

    fun onCounterButtonClick() {
        navigateTo(HomeFragmentDirections.toCounterFragment())
    }

    fun onRootCounterButtonClick() {
        navigateTo(RootNavGraphDirections.toRootCounterFragment(), rootGraph = true)
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
