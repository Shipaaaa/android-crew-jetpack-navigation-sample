package ru.shipa.navigation.sample.ui.base

import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.extension.decorate

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private val mainView by lazy { window.decorView }

    override fun showMessage(
        messageText: String,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        containerResId: Int,
        anchorViewId: Int?,
        duration: Int
    ) {

        val snack = createSnack(
            mainView = mainView,
            messageText = messageText,
            backgroundColor = R.color.snackbar_success,
            textColor = R.color.text_primary,
            containerResId = containerResId,
            duration = duration
        )

        actionTitleId?.let {
            snack?.setAction(it, action)
        }

        anchorViewId?.let { snack?.setAnchorView(it) }

        snack?.show()
    }

    override fun showError(
        messageText: String,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
        containerResId: Int,
        anchorViewId: Int?,
        duration: Int
    ) {

        val snack = createSnack(
            mainView = mainView,
            messageText = messageText,
            backgroundColor = R.color.snackbar_error,
            textColor = R.color.text_primary,
            containerResId = containerResId,
            duration = duration
        )

        actionTitleId?.let {
            snack?.setAction(it, action)
        }

        anchorViewId?.let { snack?.setAnchorView(it) }

        snack?.show()
    }

    @Suppress("LongParameterList")
    private fun createSnack(
        mainView: View,
        messageText: String,
        @ColorRes backgroundColor: Int,
        @ColorRes textColor: Int,
        containerResId: Int,
        duration: Int
    ): Snackbar? {

        val viewGroup = mainView.findViewById(containerResId) as ViewGroup?

        return viewGroup?.let {
            Snackbar
                .make(viewGroup, messageText, duration)
                .decorate(backgroundColor, textColor)
        }
    }

}
