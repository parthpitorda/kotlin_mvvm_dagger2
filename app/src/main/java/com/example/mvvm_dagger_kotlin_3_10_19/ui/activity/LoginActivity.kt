package com.example.mvvm_dagger_kotlin_3_10_19.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseActivity
import com.example.mvvm_dagger_kotlin_3_10_19.databinding.ActivityLoginBinding
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.LoginViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.utils.ViewModelFactory

class LoginActivity : BaseActivity() {
    lateinit var mDataBinding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        if (preferences.getBoolean("isUserLogin", false)) {
            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(LoginViewModel::class.java)

        mDataBinding.viewModel = viewModel

        viewModel.loginResponse.observe(this, Observer {
            editor.putBoolean("isUserLogin", true).apply()
            startActivity(Intent(context, MainActivity::class.java))
            finish()
            Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
        })


        mDataBinding.btnSubmit.setOnClickListener {
            viewModel.onLogin(
                mDataBinding.etName.text.toString(),
                mDataBinding.etPass.text.toString()
            )
        }
    }
}
