/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vclip.mercy.presentation.base.BaseActivity
import com.vclip.mercy.presentation.theme.MercySkeletonTheme
import com.vclip.mercy.presentation.view.onboarding.EndOnBoardingScreen
import com.vclip.mercy.presentation.view.onboarding.OnBoardingScreen
import com.vclip.mercy.presentation.view.onboarding.OnBoardingViewModel
import com.vclip.mercy.presentation.view.onboarding.StartOnBoardingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercyApp()
        }
    }

    @Composable
    fun MercyApp() {
        MercySkeletonTheme {
            val navController = rememberNavController()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavHost(
                    navController = navController,
                    startDestination = OnBoardingScreen.Start.route
                ) {
                    val viewModel by viewModels<OnBoardingViewModel>()
                    composable(route = OnBoardingScreen.Start.route) {
                        StartOnBoardingScreen(
                            viewModel = viewModel,
                            contents = "I'm not superstitious, but I am a little stitious",
                            onClickNextButton = {
                                navController.navigate(OnBoardingScreen.END.route)
                            }
                        )
                    }
                    composable(route = OnBoardingScreen.END.route) {
                        EndOnBoardingScreen(
                            viewModel = viewModel,
                            contents = "end"
                        )
                    }
                }
            }
        }
    }
}