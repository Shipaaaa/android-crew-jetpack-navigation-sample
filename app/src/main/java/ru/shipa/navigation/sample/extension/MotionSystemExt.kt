package ru.shipa.navigation.sample.extension

import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis

/**
 * Устанавливает анимацию переходов [MaterialFadeThrough].
 * @see incomeTransitionFadeThrough
 * @see outcomeTransitionFadeThrough
 */
fun Fragment.transitionFadeThrough() {
    incomeTransitionFadeThrough()
    outcomeTransitionFadeThrough()
}

/**
 * Устанавливает анимацию переходов [MaterialFadeThrough].
 * Затрагивает только анимацию перехода c предыдущего фрагмента.
 */
fun Fragment.incomeTransitionFadeThrough() {
    enterTransition = MaterialFadeThrough()
}

/**
 * Устанавливает анимацию переходов [MaterialFadeThrough].
 * Затрагивает только анимацию перехода на следующий фрагмент.
 */
fun Fragment.outcomeTransitionFadeThrough() {
    exitTransition = MaterialFadeThrough()
}

/**
 * Устанавливает анимацию переходов [MaterialSharedAxis] по оси [axis].
 * @see incomeTransitionSharedAxis
 * @see outcomeTransitionSharedAxis
 */
fun Fragment.transitionSharedAxis(@MaterialSharedAxis.Axis axis: Int) {
    incomeTransitionSharedAxis(axis)
    outcomeTransitionSharedAxis(axis)
}

/**
 * Устанавливает анимацию переходов [MaterialSharedAxis] по оси [axis].
 * Затрагивает только анимацию перехода из родительского фрагмента и возврата в него.
 */
fun Fragment.incomeTransitionSharedAxis(@MaterialSharedAxis.Axis axis: Int) {
    val forward = MaterialSharedAxis(axis, true)
    enterTransition = forward

    val backward = MaterialSharedAxis(axis, false)
    returnTransition = backward
}

/**
 * Устанавливает анимацию переходов [MaterialSharedAxis] по оси [axis].
 * Затрагивает только анимацию перехода в дочерний фрагмент и возврата из него.
 */
fun Fragment.outcomeTransitionSharedAxis(@MaterialSharedAxis.Axis axis: Int) {
    val backward = MaterialSharedAxis(axis, false)
    reenterTransition = backward

    val forward = MaterialSharedAxis(axis, true)
    exitTransition = forward
}
