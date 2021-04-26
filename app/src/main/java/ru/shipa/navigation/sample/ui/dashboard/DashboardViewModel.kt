package ru.shipa.navigation.sample.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shipa.navigation.sample.ui.base.BaseViewModel
import ru.shipa.navigation.sample.ui.home.HomeFragmentDirections

class DashboardViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    val text: LiveData<String> = _text

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
