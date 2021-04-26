package ru.shipa.navigation.sample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shipa.navigation.sample.ui.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
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
