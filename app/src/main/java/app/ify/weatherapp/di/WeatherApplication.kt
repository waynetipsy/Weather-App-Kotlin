package app.ify.weatherapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// custom app class that Hilt uses to create
// the app-wide Dependency Graph

@HiltAndroidApp
class WeatherApplication : Application(){
}