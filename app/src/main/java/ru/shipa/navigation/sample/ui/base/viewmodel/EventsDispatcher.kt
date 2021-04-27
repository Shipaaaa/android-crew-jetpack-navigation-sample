package ru.shipa.navigation.sample.ui.base.viewmodel

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import com.redmadrobot.extensions.lifecycle.EventQueue
import ru.shipa.navigation.sample.ui.base.viewmodel.event.NavigationEvent
import ru.shipa.navigation.sample.ui.base.viewmodel.event.ShowSnackbarErrorEvent
import ru.shipa.navigation.sample.ui.base.viewmodel.event.ShowSnackbarMessageEvent

interface EventsDispatcher {

    val events: EventQueue

    fun showMessage(message: String) {
        events.offerEvent(ShowSnackbarMessageEvent(message))
    }

    fun showError(message: String) {
        events.offerEvent(ShowSnackbarErrorEvent(message))
    }

    fun navigateTo(direction: NavDirections, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToDirection(direction, rootGraph))
    }

    fun navigateTo(@IdRes resId: Int, args: Bundle? = null, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToRes(resId, args, rootGraph))
    }

    fun navigateUp() {
        events.offerEvent(NavigationEvent.Up())
    }

    fun navigateBack() {
        events.offerEvent(NavigationEvent.Back())
    }

    fun navigateBackTo(destinationId: Int, inclusive: Boolean) {
        events.offerEvent(NavigationEvent.BackTo(destinationId, inclusive))
    }
}
