package com.example.mvvm_dagger_kotlin_3_10_19.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseFragment
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.FragmentOneBinding
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.RawUserBinding


class OneFragment : BaseFragment() {
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_one, container, false
        )
        return binding.root

    }

}
