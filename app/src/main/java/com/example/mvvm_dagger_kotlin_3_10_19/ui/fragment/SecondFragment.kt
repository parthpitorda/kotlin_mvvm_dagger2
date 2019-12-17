package com.example.mvvm_dagger_kotlin_3_10_19.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseFragment
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.ActivityMainBinding
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.FragmentOneBinding
import com.example.mvvm_dagger_kotlin_3_10_19.ui.activity.DetailActivity
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.UserViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.utils.ViewModelFactory
import com.squareup.picasso.Picasso

class SecondFragment : BaseFragment() {
    lateinit var mDataBinding: ActivityMainBinding
    lateinit var viewModel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.activity_main, container, false)

        viewModel = ViewModelProviders.of(this, ViewModelFactory((context as DetailActivity)))
            .get(UserViewModel::class.java)

        viewModel.loadingVisibility.observe(this, Observer {
            if (viewModel.loadingVisibility.value == 8) {

                viewModel.responseViewFlipper.forEach {
                    val imageView = ImageView(context)
                    Picasso.get().load(it.avatar).into(imageView)
                    mDataBinding.viewFlipper.addView(imageView)
                }
            }
        })

        mDataBinding.viewModel = viewModel


        return mDataBinding.root

    }
}