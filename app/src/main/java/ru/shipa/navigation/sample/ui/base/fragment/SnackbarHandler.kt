package ru.shipa.navigation.sample.ui.base.fragment

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

interface SnackbarHandler {

    /**
     * Метод нужен для привязывания [Snackbar] к конкретному
     * [CoordinatorLayout][androidx.coordinatorlayout.widget.CoordinatorLayout].
     *
     * По-умолчанию [Snackbar] отрисовывается на уровне activity ([android.R.id.content]).
     * В случаях где [Snackbar] должен отрисовывается в другом контйейнере,
     * например, на уровне [Fragment][androidx.fragment.app.Fragment] из раздела
     * [BottomNavigationView][com.google.android.material.bottomnavigationBottomNavigationView], нужно переопределить этот метод.
     *
     * Подробности в методе [Snackbar.findSuitableParent].
     *
     * @return id [CoordinatorLayout][androidx.coordinatorlayout.widget.CoordinatorLayout] контейнера, в котором будут показываться [Snackbar].
     */
    @IdRes
    fun getMessagesContainer(): Int = android.R.id.content

    /**
     * Метод нужен для привязывания [Snackbar] к конкретному элементу экрана.
     * Например, чтобы показать его над кнопками или другими элементами.
     *
     * Также нужно переопределить id контейнера [getMessagesContainer]
     *
     * @return id view, над которой будут показываться [Snackbar].
     */
    @IdRes
    fun getSnackbarAnchorView(): Int? = null

    @Suppress("LongParameterList")
    fun showMessage(
        messageText: String,
        @IdRes containerResId: Int,
        @IdRes anchorViewId: Int?,
        @StringRes actionTitleId: Int? = null,
        action: ((View) -> Unit)? = null,
        duration: Int = Snackbar.LENGTH_LONG
    )

    @Suppress("LongParameterList")
    fun showError(
        messageText: String,
        @IdRes containerResId: Int,
        @IdRes anchorViewId: Int?,
        @StringRes actionTitleId: Int? = null,
        action: ((View) -> Unit)? = null,
        duration: Int = Snackbar.LENGTH_LONG
    )

}
