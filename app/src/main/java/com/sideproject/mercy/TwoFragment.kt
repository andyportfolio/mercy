package com.sideproject.mercy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sideproject.mercy.databinding.FragmentTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TwoFragment : Fragment() {

    private lateinit var binding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }
}