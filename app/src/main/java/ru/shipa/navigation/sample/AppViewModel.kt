package ru.shipa.navigation.sample

import androidx.lifecycle.distinctUntilChanged
import ru.shipa.navigation.sample.ui.base.viewmodel.BaseViewModel

class AppViewModel : BaseViewModel<StartScreenViewState>() {

    val startScreen = liveState.distinctUntilChanged()

    init {
        updateState(StartScreenViewState(R.id.loginFragment))
    }

}
