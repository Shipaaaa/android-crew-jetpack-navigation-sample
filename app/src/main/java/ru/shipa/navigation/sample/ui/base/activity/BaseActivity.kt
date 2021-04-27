package ru.shipa.navigation.sample.ui.base.activity

import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ru.shipa.navigation.sample.R
import ru.shipa.navigation.sample.extension.decorate

abstract class BaseActivity : AppCompatActivity() {

    private val mainView by lazy { window.decorView }

    fun showMessage(
        messageText: String,
        containerResId: Int,
        anchorViewId: Int?,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
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

    fun showError(
        messageText: String,
        containerResId: Int,
        anchorViewId: Int?,
        actionTitleId: Int?,
        action: ((View) -> Unit)?,
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
