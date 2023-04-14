package com.sideproject.mercy.presentation.view.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.domain.entity.OnBoarding
import com.sideproject.mercy.domain.usecase.GetOnBoardingCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getOnBoardingCase: GetOnBoardingCase
) : ViewModel() {

    private val _onBoarding = MutableStateFlow<Resource<OnBoarding>>(Resource.Loading())
    val onBoarding: StateFlow<Resource<OnBoarding>> = _onBoarding.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = Resource.Loading()
    )

    fun getOnBoarding() = viewModelScope.launch {
        getOnBoardingCase.invoke().collect { values ->
            _onBoarding.value = values
        }
    }

    init {
        getOnBoarding()
    }
}

