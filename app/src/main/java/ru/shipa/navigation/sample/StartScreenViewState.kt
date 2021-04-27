package ru.shipa.navigation.sample

import android.os.Bundle
import androidx.annotation.IdRes
import ru.shipa.navigation.sample.ui.base.viewmodel.state.BaseState

data class StartScreenViewState(
    @IdRes val resId: Int,
    val args: Bundle? = null
) : BaseState
