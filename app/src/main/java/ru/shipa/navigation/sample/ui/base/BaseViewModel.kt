package ru.shipa.navigation.sample.ui.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.redmadrobot.extensions.lifecycle.EventQueue

abstract class BaseViewModel : ViewModel() {

    val events = EventQueue()

    protected fun showMessage(message: String) {
        events.offerEvent(ShowSnackbarMessage(message))
    }

    protected fun showError(message: String) {
        events.offerEvent(ShowSnackbarError(message))
    }

    protected fun navigateTo(direction: NavDirections, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToDirection(direction, rootGraph))
    }

    protected fun navigateTo(@IdRes resId: Int, args: Bundle? = null, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToRes(resId, args, rootGraph))
    }

    protected fun navigateUp() {
        events.offerEvent(NavigationEvent.Up())
    }

    protected fun navigateBack() {
        events.offerEvent(NavigationEvent.Back())
    }

    protected fun navigateBackTo(destinationId: Int, inclusive: Boolean) {
        events.offerEvent(NavigationEvent.BackTo(destinationId, inclusive))
    }
}


