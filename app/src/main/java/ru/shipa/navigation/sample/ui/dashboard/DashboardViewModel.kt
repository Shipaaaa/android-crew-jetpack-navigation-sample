package ru.shipa.navigation.sample.ui.dashboard

import androidx.lifecycle.distinctUntilChanged
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel
import ru.shipa.navigation.sample.ui.home.HomeFragmentDirections

class DashboardViewModel : BaseViewModel<DashboardViewState>() {

    init {
        updateState(DashboardViewState("This is dashboard Fragment"))
    }

    val textState = liveState.distinctUntilChanged()

    fun onCounterButtonClick() {
        navigateTo(HomeFragmentDirections.toCounterFragment())
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
