package ru.shipa.navigation.sample.ui.base.viewmodel.event

import com.redmadrobot.extensions.lifecycle.Event

/**
 * События описывающие отображения Snackbar.
 */

data class ShowSnackbarMessageEvent(val message: String) : Event

data class ShowSnackbarErrorEvent(val message: String) : Event
