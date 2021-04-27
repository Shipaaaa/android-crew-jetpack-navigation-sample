package ru.shipa.navigation.sample.ui.base.fragment

import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.redmadrobot.extensions.lifecycle.Event
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.extension.navigateSafe
import ru.shipa.navigation.sample.ui.base.activity.BaseActivity
import ru.shipa.navigation.sample.ui.base.viewmodel.event.NavigationEvent
import ru.shipa.navigation.sample.ui.base.viewmodel.event.ShowSnackbarErrorEvent
import ru.shipa.navigation.sample.ui.base.viewmodel.event.ShowSnackbarMessageEvent

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), SnackbarHandler {

    private val baseActivity by lazy { activity as BaseActivity }

    override fun showMessage(
        messageText: String,
        containerResId: Int,
        anchorViewId: Int?,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        duration: Int
    ) {
        baseActivity.showMessage(
            messageText = messageText,
            containerResId = containerResId,
            anchorViewId = anchorViewId,
            actionTitleId = actionTitleId,
            action = action,
            duration = duration
        )
    }

    override fun showError(
        messageText: String,
        containerResId: Int,
        anchorViewId: Int?,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        duration: Int
    ) {
        baseActivity.showError(
            messageText = messageText,
            containerResId = containerResId,
            anchorViewId = anchorViewId,
            actionTitleId = actionTitleId,
            action = action,
            duration = duration
        )
    }

    @CallSuper
    protected open fun handleEvents(event: Event) {
        when (event) {
            is NavigationEvent -> handleNavigationEvent(event)

            is ShowSnackbarMessageEvent -> {
                showMessage(
                    messageText = event.message,
                    containerResId = getMessagesContainer(),
                    anchorViewId = getSnackbarAnchorView()
                )
            }
            is ShowSnackbarErrorEvent -> {
                showError(
                    messageText = event.message,
                    containerResId = getMessagesContainer(),
                    anchorViewId = getSnackbarAnchorView()
                )
            }
        }
    }

    private fun handleNavigationEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.ToDirection -> getNavController(event.rootGraph).navigateSafe(event.direction)
            is NavigationEvent.ToRes -> getNavController(event.rootGraph).navigateSafe(event.resId, event.args)
            is NavigationEvent.Up -> findNavController().navigateUp()
            is NavigationEvent.Back -> if (!findNavController().popBackStack()) requireActivity().finish()
            is NavigationEvent.BackTo -> findNavController().popBackStack(event.destinationId, event.inclusive)
        }
    }

    private fun getNavController(rootGraph: Boolean = false): NavController {
        return if (rootGraph) {
            requireActivity().findNavController(R.id.activity_app_screens_container)
        } else {
            findNavController()
        }
    }
}
