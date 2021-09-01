package com.ilagoproject.myapplication.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ilagoproject.myapplication.R
import com.ilagoproject.myapplication.databinding.FragmentAuthorizationBinding
import com.ilagoproject.myapplication.databinding.FragmentMainBinding

class AccountInfoFragment : AccountViewModelFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.viewModel = this
        return binding.root
    }
}