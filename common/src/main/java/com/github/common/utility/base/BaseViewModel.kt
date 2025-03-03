package com.github.common.utility.base


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * A base ViewModel that follows the MVI (Model-View-Intent) architecture pattern.
 *
 * This ViewModel:
 * - Manages state using a `StateFlow`.
 * - Processes UI events with a `SharedFlow`.
 * - Emits one-time effects via a `Channel`.
 * - Supports time-travel debugging with `TimeCapsule`.
 *
 * @param State The type representing the UI state.
 * @param Event The type representing UI events.
 * @param Effect The type representing UI side effects.
 * @param initialState The initial state of the ViewModel.
 * @param reducer The reducer responsible for handling state transitions.
 */
abstract class BaseViewModel<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect>(
    initialState: State, private val reducer: Reducer<State, Event, Effect>
) : ViewModel() {

    // State management
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    // Event flow for UI interactions
    private val _event = MutableSharedFlow<Event>()
    val event: SharedFlow<Event> = _event.asSharedFlow()

    // Effect channel for one-time UI actions (e.g., navigation, toasts)
    private val _effects = Channel<Effect>(capacity = Channel.CONFLATED)
    val effect: Flow<Effect> = _effects.receiveAsFlow()

    // Time travel debugging support
    val timeCapsule: TimeCapsule<State> = TimeTravelCapsule { storedState ->
        _state.tryEmit(storedState)
    }

    init {
        timeCapsule.addState(initialState)
    }

    /**
     * Sends a one-time effect to the UI.
     *
     * @param effect The effect to be emitted.
     */
    fun sendEffect(effect: Effect) {
        _effects.trySend(effect)
    }

    /**
     * Processes a UI event and updates the state accordingly.
     *
     * @param event The event to be handled.
     */
    fun sendEvent(event: Event) {
        val (newState, _) = reducer.reduce(_state.value, event)
        if (_state.tryEmit(newState)) {
            timeCapsule.addState(newState)
        }
    }

    /**
     * Processes a UI event, updates the state, and optionally sends an effect.
     *
     * @param event The event to be handled.
     */
    fun sendEventForEffect(event: Event) {
        val (newState, effect) = reducer.reduce(_state.value, event)
        if (_state.tryEmit(newState)) {
            timeCapsule.addState(newState)
        }
        effect?.let { sendEffect(it) }
    }
}
