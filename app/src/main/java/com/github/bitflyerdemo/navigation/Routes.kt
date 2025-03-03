package com.github.bitflyerdemo.navigation

import kotlinx.serialization.Serializable

/**
 * Represents the Home screen as a navigation route.
 *
 * Since this is a simple navigation object with no parameters,
 * it is defined as an object to avoid unnecessary instantiations.
 */
@Serializable
object Home

/**
 * Represents the Detail screen navigation route.
 *
 * @property userName The username passed as an argument for the detail screen.
 */
@Serializable
data class Detail(val userName: String)

