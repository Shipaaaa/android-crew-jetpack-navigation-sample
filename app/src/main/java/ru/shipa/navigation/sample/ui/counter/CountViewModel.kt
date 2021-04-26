package ru.shipa.navigation.sample.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.shipa.navigation.sample.ui.base.BaseViewModel

class CountViewModel : BaseViewModel() {

    private val _text = MutableLiveData<Int>()

    val text: LiveData<Int> = _text

    fun setCount(count: Int) {
        _text.value = if (count < 0) 1 else count
    }

    fun onCountButtonClick() {
        val counter = text.value ?: return

        navigateTo(
            CounterFragmentDirections.toNextCounterFragment(counter + 1)
        )
    }

    fun onSuccessButtonClick() {
        showMessage("Кнопка успешно нажата!")
    }

    fun onErrorButtonClick() {
        showError("Что-то пошло не так...")
    }
}
