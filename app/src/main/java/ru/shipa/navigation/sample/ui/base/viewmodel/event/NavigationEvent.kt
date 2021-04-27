package ru.shipa.navigation.sample.ui.base.viewmodel.event

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import com.redmadrobot.extensions.lifecycle.Event

/**
 * События описывающие навигацию.
 */
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

    data class BackTo(
        val destinationId: Int,
        val inclusive: Boolean
    ) : NavigationEvent()
}
