package com.github.common.utility.base

/**
 * Interface for a time capsule that stores previous states and allows time-travel debugging.
 *
 * @param S The type representing the ViewState.
 */
interface TimeCapsule<S : Reducer.ViewState> {

    /**
     * Adds a new state to the time capsule.
     *
     * @param state The state to be stored.
     */
    fun addState(state: S)

    /**
     * Selects a previously stored state by its position in the history.
     *
     * @param position The index of the state in the stored history.
     */
    fun selectState(position: Int)

    /**
     * Retrieves the list of all stored states.
     *
     * @return A list of saved states.
     */
    fun getStates(): List<S>
}

/**
 * Implementation of [TimeCapsule] that allows tracking and restoring previous states.
 *
 * @param S The type representing the ViewState.
 * @param onStateSelected Callback function to restore a selected state.
 */
class TimeTravelCapsule<S : Reducer.ViewState>(
    private val onStateSelected: (S) -> Unit
) : TimeCapsule<S> {

    private val states = mutableListOf<S>()

    /**
     * Adds a new state to the history.
     *
     * @param state The state to be stored.
     */
    override fun addState(state: S) {
        states.add(state)
    }

    /**
     * Restores a previously stored state based on the provided position.
     *
     * @param position The index of the state to restore.
     * @throws IndexOutOfBoundsException If the position is invalid.
     */
    override fun selectState(position: Int) {
        if (position in states.indices) {
            onStateSelected(states[position])
        } else {
            throw IndexOutOfBoundsException("Invalid state position: $position")
        }
    }

    /**
     * Retrieves all stored states.
     *
     * @return A list of saved states.
     */
    override fun getStates(): List<S> = states.toList()
}
