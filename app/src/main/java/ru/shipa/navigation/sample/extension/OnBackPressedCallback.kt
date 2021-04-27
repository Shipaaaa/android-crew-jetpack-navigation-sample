package ru.shipa.navigation.sample.extension

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

/**
 * Добавление коллбэка для нажатия "назад".
 *
 * Коллбэк нужно добавлять в [Fragment.onAttach]. Коллбэки привязаны к жизненному циклу фрагмента,
 * поэтому при уничтожении фрагмента перестанут работать.
 * ```
 *  class MyFragment : Fragment() {
 *      override fun onAttach(context: Context) {
 *          super.onAttach(context)
 *          addOnBackPressedCallback {
 *              showAreYouSureDialog()
 *          }
 *      }
 *  }
 * ```
 * @param enabled Состояние коллбэка по умолчанию. Если не задано - `true`.
 * @return Созданный коллбэк, который можно отключить при помощи [OnBackPressedCallback.setEnabled] или
 * удалить с помощью [OnBackPressedCallback.remove].
 * @see OnBackPressedCallback
 * @see androidx.activity.OnBackPressedDispatcher
 */
fun Fragment.addOnBackPressedCallback(
    enabled: Boolean = true,
    onBackPressed: OnBackPressedCallback.() -> Unit
): OnBackPressedCallback {
    return object : OnBackPressedCallback(enabled) {
        override fun handleOnBackPressed() = onBackPressed()
    }.also { requireActivity().onBackPressedDispatcher.addCallback(this, it) }
}
