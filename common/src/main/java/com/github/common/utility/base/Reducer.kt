package com.github.common.utility.base

/**
 * A generic Reducer interface that defines how state transitions occur
 * based on events and optionally produces side effects.
 *
 * @param State The type representing the UI state.
 * @param Event The type representing UI events.
 * @param Effect The type representing UI side effects.
 */
interface Reducer<State : Reducer.ViewState, Event : Reducer.ViewEvent, Effect : Reducer.ViewEffect> {

    /**
     * Represents a state in the UI.
     */
    interface ViewState

    /**
     * Represents an event triggered by the UI.
     */
    interface ViewEvent

    /**
     * Represents a side effect that occurs as a result of an event.
     */
    interface ViewEffect

    /**
     * Reduces the current state based on an event and optionally returns an effect.
     *
     * @param previousState The current state before applying the event.
     * @param event The event that occurred.
     * @return A pair containing the new state and an optional effect.
     */
    fun reduce(previousState: State, event: Event): Pair<State, Effect?>
}
