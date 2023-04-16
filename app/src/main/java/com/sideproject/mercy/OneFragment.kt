package com.sideproject.mercy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.RoundedCornersTransformation
import com.sideproject.mercy.common.Resource
import com.sideproject.mercy.databinding.FragmentOneBinding
import com.sideproject.mercy.domain.entity.OnBoarding
import com.sideproject.mercy.presentation.base.BaseFragment
import com.sideproject.mercy.presentation.view.onboarding.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OneFragment : BaseFragment() {
    private val viewModel by viewModels<OnBoardingViewModel>()
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun setupListeners() {
        binding.loadDataButton.setOnClickListener {
            viewModel.getOnBoarding()
        }
    }

    override fun subscribeToViewModels() {
        lifecycleScope.launch {
            viewModel.onBoarding.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect { response ->
                    handleBoardingData(response)
                }
        }
    }

    private fun handleBoardingData(response: Resource<OnBoarding>) {
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