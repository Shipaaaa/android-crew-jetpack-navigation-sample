package ru.shipa.navigation.sample.ui.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redmadrobot.extensions.lifecycle.EventQueue
import ru.shipa.navigation.sample.extension.delegate
import ru.shipa.navigation.sample.extension.onNext
import ru.shipa.navigation.sample.ui.base.viewmodel.state.BaseState

abstract class BaseViewModel<T : BaseState>(
    initialState: T? = null
) : ViewModel(),
    EventsDispatcher {

    protected val liveState = MutableLiveData<T>().apply {
        initialState?.let { onNext(it) }
    }

    protected var state: T by liveState.delegate()

    override val events = EventQueue()

    /**
     * Метод для установки состояния экрана.
     * Позволяет отследить все обновления состояния на сложных экранах.
     *
     * Пример:
     * ```
     *  updateState(Loading())
     * ```
     */
    protected fun updateState(newState: T) {
        state = newState
    }

    /**
     * Метод для изменения состояния экрана.
     * Позволяет отследить все обновления состояния на сложных экранах.
     *
     * Пример:
     * ```
     *  updateState {
     *      copy(
     *          favouriteFilmsState = Content(favouriteFilms),
     *          needShowSwipeRefresh = false
     *      )
     *  }
     * ```
     */
    protected fun updateState(block: T.() -> T) {
        state = block.invoke(state)
    }
}


