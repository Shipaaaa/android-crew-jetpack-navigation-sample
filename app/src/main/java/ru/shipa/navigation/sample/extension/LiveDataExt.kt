package ru.shipa.navigation.sample.extension

import androidx.lifecycle.MutableLiveData
import com.redmadrobot.extensions.lifecycle.requireValue
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Delegate for easier work with [MutableLiveData] content.
 *
 * It is shortest version of:
 * ```
 *  val liveState = MutableLiveData<IntroViewState>(initialState)
 *  var state: IntroViewState
 *      get() = liveState.requireValue()
 *      set(value) = liveState.onNext(value)
 * ```
 * With delegate you can replace it with next code:
 * ```
 *  val liveState = MutableLiveData<IntroViewState>(initialState)
 *  var state: IntroViewState by liveState.delegate()
 * ```
 */
fun <T : Any> MutableLiveData<T>.delegate(): ReadWriteProperty<Any, T> {
    return object : ReadWriteProperty<Any, T> {
        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) = onNext(value)
        override fun getValue(thisRef: Any, property: KProperty<*>): T = requireValue()
    }
}

fun <T> MutableLiveData<T>.onNext(next: T) {
    this.value = next
}
