package com.sideproject.mercy.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.databinding.ActivityMainBinding
import com.sideproject.mercy.presentation.base.BaseActivity
import com.sideproject.mercy.presentation.view.onboarding.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<OnBoardingViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchData()
    }


    private fun fetchData() {
        viewModel.getOnBoarding()

        lifecycleScope.launch {
            viewModel.onBoarding.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { response ->
                    when (response) {
                        is Resource.Success -> {
                            binding.textView.text = response.data?.title
                            binding.imageView.load(response.data?.imageUrl) {
                                transformations(RoundedCornersTransformation(16f))
                            }
                        }
                        is Resource.Error -> {
                            binding.textView.text = response.message.toString()
                        }
                        is Resource.Loading -> {
                            binding.textView.text = "Loading...."
                        }
                    }
                }
        }
    }
}