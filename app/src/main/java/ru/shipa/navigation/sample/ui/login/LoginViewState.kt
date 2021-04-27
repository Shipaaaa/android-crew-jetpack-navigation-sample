package ru.shipa.navigation.sample.ui.login

import ru.shipa.navigation.sample.ui.base.viewmodel.state.BaseState

data class LoginViewState(
    val login: String,
    val password: String,
    val buttonEnabled: Boolean,
) : BaseState {

    companion object {
        fun createInitialState(): LoginViewState {
            return LoginViewState(
                login = "",
                password = "",
                buttonEnabled = false
            )
        }
    }

}
