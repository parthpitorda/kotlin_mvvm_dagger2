package com.example.mvvm_dagger_kotlin_3_10_19.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseActivity
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.ActivityMainBinding
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.UserViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MainActivity : BaseActivity() {

    lateinit var mDatabinding: ActivityMainBinding
    lateinit var viewModel: UserViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDatabinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(UserViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })

        viewModel.loadingVisibility.observe(this, Observer {
            if (viewModel.loadingVisibility.value == 8) {

                viewModel.responseViewFlipper.forEach {
                    val imageView = ImageView(this)
                    Picasso.get().load(it.avatar).into(imageView)
                    mDatabinding.viewFlipper.addView(imageView)
                }
            }
        })

        mDatabinding.viewModel = viewModel

    }


    private fun showError(errorMessage: String) {
        errorSnackbar = Snackbar.make(mDatabinding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction("Retry", viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
