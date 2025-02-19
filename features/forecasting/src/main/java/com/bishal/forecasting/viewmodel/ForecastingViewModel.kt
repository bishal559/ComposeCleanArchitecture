package com.bishal.forecasting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bishal.data.network.Resource
import com.bishal.forecasting.usecase.ForecastingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
/**
 *
 * Created by bishal adhikari on 08/10/2024
 * */
@HiltViewModel
class ForecastingViewModel @Inject constructor(private val useCase: ForecastingUseCase): ViewModel() {

    private val _state = MutableStateFlow<Resource<Any>?>(null)
    val state: StateFlow<Resource<Any>?> = _state


    fun getForecastedWeather() = viewModelScope.launch {

        _state.value = Resource.Loading()

        val result = useCase.getForecastingDays()

        result.fold(
            onSuccess = {
                _state.value = Resource.Success(it)
            },
            onFailure = {
                _state.value = Resource.Error("Unknown Error", it)
            }
        )
    }

    fun parseDateToDay(dateString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd")
        val outputFormat = SimpleDateFormat("EEE, dd MMM")
        val date: Date? = try {
            inputFormat.parse(dateString)
        } catch (e: ParseException) {
            return dateString
        }
        return outputFormat.format(date)
    }

}