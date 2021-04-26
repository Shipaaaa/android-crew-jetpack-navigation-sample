package ru.shipa.navigation.sample.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

/**
 * Позволяет осуществлять переход по навигации в безопасном режиме и
 * предотвращает краш при открытии более чем одного экрана (мультитач нажатии).
 */
fun NavController.navigateSafe(direction: NavDirections) {
    currentDestination?.getAction(direction.actionId)?.let { navigate(direction) }
}

/**
 * Позволяет осуществлять переход по навигации в безопасном режиме и
 * предотвращает краш при открытии более чем одного экрана (мультитач нажатии).
 */
fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)

    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}
