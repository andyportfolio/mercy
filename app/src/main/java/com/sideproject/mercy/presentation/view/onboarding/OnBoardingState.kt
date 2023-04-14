package com.sideproject.mercy.presentation.view.onboarding

import com.sideproject.mercy.domain.entity.OnBoarding

data class OnBoardingState(
    val isLoading: Boolean = false,
    val data: OnBoarding? = null,
    val error: String = ""
)
