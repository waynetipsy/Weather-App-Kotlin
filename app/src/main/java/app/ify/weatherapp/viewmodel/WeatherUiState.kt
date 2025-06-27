package app.ify.weatherapp.viewmodel

import app.ify.weatherapp.model.WeatherInfo

// Defines a fixed set of subclasses
sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val weatherInfo: WeatherInfo) : WeatherUiState()
    data class Error(val errorMessage: String) : WeatherUiState()
}