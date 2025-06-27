package app.ify.weatherapp.viewmodel

import app.ify.weatherapp.repo.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


// @HiltViewModel: tells hilt this Viewmodel should be injectable
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    // UI State
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val  _locations = MutableStateFlow<List<String>>(emptyList())
    val locations: StateFlow<List<String>> = _locations.asStateFlow()

    private val _selectedLocation = MutableStateFlow<String>(value = "")
    val selectedLocation: StateFlow<String> = _selectedLocation.asStateFlow()
}