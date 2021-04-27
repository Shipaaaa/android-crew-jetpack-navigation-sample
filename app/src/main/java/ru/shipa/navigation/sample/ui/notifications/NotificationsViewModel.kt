package ru.shipa.navigation.sample.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shipa.navigation.sample.ui.base.BaseViewModel
import ru.shipa.navigation.sample.ui.home.HomeFragmentDirections

class NotificationsViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }

    val text: LiveData<String> = _text

    fun onCounterButtonClick() {
        navigateTo(HomeFragmentDirections.toCounterFragment())
    }

    fun onExitButtonClick() {
        navigateBack()
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
