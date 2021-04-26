package ru.shipa.navigation.sample.ui.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import com.redmadrobot.extensions.lifecycle.Event

sealed class NavigationEvent : Event {
    data class ToDirection(
        val direction: NavDirections,
        val rootGraph: Boolean = false
    ) : NavigationEvent()

    data class ToRes(
        @IdRes val resId: Int,
        val args: Bundle? = null,
        val rootGraph: Boolean = false
    ) : NavigationEvent()

    class Up : NavigationEvent()

    class Back : NavigationEvent()

    data class BackTo(val destinationId: Int, val inclusive: Boolean) : NavigationEvent()
}

data class ShowSnackbarMessage(val message: String) : Event

data class ShowSnackbarError(val message: String) : Event
