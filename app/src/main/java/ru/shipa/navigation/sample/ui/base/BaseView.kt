package ru.shipa.navigation.sample.ui.base

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

interface BaseView {

    @Suppress("LongParameterList")
    fun showMessage(
        messageText: String,
        @StringRes actionTitleId: Int? = null,
        action: ((View) -> Unit)? = null,
        @IdRes containerResId: Int = android.R.id.content,
        @IdRes anchorViewId: Int? = null,
        duration: Int = Snackbar.LENGTH_LONG
    )

    @Suppress("LongParameterList")
    fun showError(
        messageText: String,
        @StringRes actionTitleId: Int? = null,
        action: ((View) -> Unit)? = null,
        @IdRes containerResId: Int = android.R.id.content,
        @IdRes anchorViewId: Int? = null,
        duration: Int = Snackbar.LENGTH_LONG
    )

}
