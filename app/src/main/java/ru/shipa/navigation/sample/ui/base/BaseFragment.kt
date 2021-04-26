package ru.shipa.navigation.sample.ui.base

import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.redmadrobot.extensions.lifecycle.Event
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.extension.navigateSafe

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), BaseView {

    /**
     * id контейнера, в котором будут показываться SnackBar
     * Это нужно для того, чтобы на некоторых экранах показать его над BottomBar
     * В таких случаях нужно переопределить id контейнера
     */
    @IdRes
    protected open val messagesContainer: Int = android.R.id.content

    private val baseActivity by lazy { activity as BaseView }

    override fun showMessage(
        messageText: String,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        containerResId: Int,
        anchorViewId: Int?,
        duration: Int
    ) {
        baseActivity.showMessage(messageText, actionTitleId, action, containerResId, anchorViewId, duration)
    }

    override fun showError(
        messageText: String,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        containerResId: Int,
        anchorViewId: Int?,
        duration: Int
    ) {
        baseActivity.showError(messageText, actionTitleId, action, containerResId, anchorViewId, duration)
    }

    @CallSuper
    protected open fun handleEvent(event: Event) {
        when (event) {
            is NavigationEvent -> handleNavigationEvent(event)

            is ShowSnackbarMessage -> {
                showMessage(
                    messageText = event.message,
                    containerResId = messagesContainer,
                    anchorViewId = getSnackbarAnchorView()
                )
            }

            is ShowSnackbarError -> {
                showError(
                    messageText = event.message,
                    containerResId = messagesContainer,
                    anchorViewId = getSnackbarAnchorView()
                )
            }
        }
    }

    /**
     * @return id view, над которой будут показываться SnackBar
     * Это нужно для того, чтобы на некоторых экранах показать его над кнопками или другими элементами.
     * Также нужно переопределить id контейнера [messagesContainer]
     */
    @IdRes
    protected open fun getSnackbarAnchorView(): Int? = null

    private fun getNavController(rootGraph: Boolean = false): NavController {
        return if (rootGraph) {
            requireActivity().findNavController(R.id.activity_app_screens_container)
        } else {
            findNavController()
        }
    }

    private fun handleNavigationEvent(event: NavigationEvent) {
        when (event) {
            is NavigationEvent.ToDirection -> getNavController(event.rootGraph).navigateSafe(event.direction)
            is NavigationEvent.ToRes -> getNavController(event.rootGraph).navigateSafe(
                event.resId,
                event.args
            )
            is NavigationEvent.Up -> findNavController().navigateUp()
            is NavigationEvent.Back -> if (!findNavController().popBackStack()) requireActivity().finish()
            is NavigationEvent.BackTo -> findNavController().popBackStack(
                event.destinationId,
                event.inclusive
            )
        }
    }
}
