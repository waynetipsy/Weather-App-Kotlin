package app.ify.weatherapp.repo

import app.ify.weatherapp.model.WeatherInfo

// interface for the repository that provides weather data
// this is what we'll inject
// using an interface allows us to swap implementations(like for testing)

interface WeatherRepository {

    fun getWeatherForLocation(location: String) : WeatherInfo
    fun getAllLocations(): List<String>
}