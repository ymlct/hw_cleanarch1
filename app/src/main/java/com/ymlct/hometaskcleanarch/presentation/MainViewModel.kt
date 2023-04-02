package com.ymlct.hometaskcleanarch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ymlct.hometaskcleanarch.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _viewState = MutableSharedFlow<ViewEvent>()
    val viewState = _viewState.asSharedFlow()

    init {
        checkIfShouldSuggestRateApp()
    }

    private fun checkIfShouldSuggestRateApp() {
        viewModelScope.launch(Dispatchers.IO) {
            if(useCases.shouldSuggestRateAppUseCase())
                _viewState.emit(ViewEvent.SuggestRateApp)
        }
    }

}