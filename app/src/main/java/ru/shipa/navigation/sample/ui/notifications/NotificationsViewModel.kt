package ru.shipa.navigation.sample.ui.notifications

import androidx.lifecycle.distinctUntilChanged
import ru.shipa.navigation.sample.RootNavGraphDirections
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel
import ru.shipa.navigation.sample.ui.home.HomeFragmentDirections

class NotificationsViewModel : BaseViewModel<NotificationsViewState>() {

    init {
        updateState(NotificationsViewState("This is notifications Fragment"))
    }

    val textState = liveState.distinctUntilChanged()

    fun onCounterButtonClick() {
        navigateTo(HomeFragmentDirections.toCounterFragment())
    }

    fun onExitButtonClick() {
        navigateTo(RootNavGraphDirections.logout(), rootGraph = true)
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
