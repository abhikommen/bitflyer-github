package com.github.bitflyerdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for the app.
 *
 * This class is annotated with `@HiltAndroidApp` to set up
 * dependency injection (DI) using Hilt across the application.
 */
@HiltAndroidApp
class MyApp : Application()