package ru.shipa.navigation.sample.ui.login

import com.redmadrobot.extensions.lifecycle.mapDistinct
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel

class LoginViewModel : BaseViewModel<LoginViewState>(
    LoginViewState.createInitialState()
) {

    val login = liveState.mapDistinct { it.login }
    val password = liveState.mapDistinct { it.password }
    val buttonEnabled = liveState.mapDistinct { it.buttonEnabled }

    fun onCredentialsChanged(login: String, password: String) {
        val buttonEnabled = login.isNotBlank() && password.isNotBlank()

        updateState {
            copy(
                login = login,
                password = password,
                buttonEnabled = buttonEnabled
            )
        }
    }

    fun onEnterButtonClick(login: String, password: String) {
        // Примитивная проверка для тестирования смены состояний.
        if (login == password) {
            navigateTo(LoginFragmentDirections.toMainFragment())
        } else {
            showError("Неправильный логин или пароль")
        }
    }
}
