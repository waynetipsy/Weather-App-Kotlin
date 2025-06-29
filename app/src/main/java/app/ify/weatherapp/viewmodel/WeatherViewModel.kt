package app.ify.weatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.ify.weatherapp.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


// @HiltViewModel: tells hilt this Viewmodel should be injectable
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
): ViewModel() {

    // UI State
    // StateFlow: is a state_holder observable flow used with UI state management
    // It is Hot: it always has a current value & emits updates to collectors
    // think of it like a LiveData Replacement for modern, coroutine-based code

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val  _locations = MutableStateFlow<List<String>>(emptyList())
    val locations: StateFlow<List<String>> = _locations.asStateFlow()

    private val _selectedLocation = MutableStateFlow<String>(value = "")
    val selectedLocation: StateFlow<String> = _selectedLocation.asStateFlow()

    init {
        loadLocations()
    }

    private fun loadLocations(){
        viewModelScope.launch {
            val locationList = weatherRepository.getAllLocations()
            _locations.value = locationList

            if (locationList.isEmpty()){
                _selectedLocation.value = locationList[0]
                loadWeatherForLocation(locationList[0])

            }
        }
    }
    private fun loadWeatherForLocation(location: String){
        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading

            // In real apps, this would be an asynchronous call
            val weatherInfo = weatherRepository.getWeatherForLocation(location)
            _uiState.value = WeatherUiState.Success(weatherInfo)
        }
    }
    // called when the user picks a different city
    // updates the selected location and loads the new weather data
    fun selectedLocation(location: String){
        _selectedLocation.value = location
        loadWeatherForLocation(location)
    }
}