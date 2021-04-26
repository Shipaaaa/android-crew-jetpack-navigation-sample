package ru.shipa.navigation.sample.extension

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import ru.shipa.navigation.sample.R


/**
 * Метод отвечает за изменение внешнего вида [Snackbar].
 *
 * Метод изменяет цвет [Snackbar] через метод [Snackbar.SnackbarLayout.setBackgroundTintList] и
 * текстовые стили у [R.id.snackbar_text] и [R.id.snackbar_action]
 *
 * @param backgroundId id цвета фона из ресуров, например [android.R.color.white].
 * @param textColorId id цвета текста из ресуров, например [android.R.color.black].
 */
fun Snackbar.decorate(@ColorRes backgroundId: Int, @ColorRes textColorId: Int): Snackbar {
    // Изменение фона
    view.backgroundTintList = ContextCompat.getColorStateList(view.context, backgroundId)

    // Изменение текстового стиля
    with(view.findViewById<TextView>(R.id.snackbar_text)) {
        setTextColor(ContextCompat.getColor(view.context, textColorId))
        maxLines = Int.MAX_VALUE
        ellipsize = null
    }

    // Изменение текстового стиля
    with(view.findViewById<TextView>(R.id.snackbar_action)) {
        setTextColor(ContextCompat.getColor(view.context, textColorId))
    }

    return this
}
