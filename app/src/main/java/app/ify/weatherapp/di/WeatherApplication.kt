package app.ify.weatherapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// custom app class that Hilt uses to create
// the app-wide Dependency Graph

//@HiltAndroidApp
// 1 - Triggers Hilt's code generation at compile time
// 2 - Create DI container at the app level
// 3 - Makes Hilt aware of your app's lifecycle

@HiltAndroidApp
class WeatherApplication : Application(){
}