package com.example.mvvm_dagger_kotlin_3_10_19.base

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.rest.ApiInterface
import com.example.mvvm_dagger_kotlin_3_10_19.rest.ApiInterfaceBase
import javax.inject.Inject
import javax.inject.Named

abstract class BaseViewModel : ViewModel() {

    @Named("photo")
    @Inject
    lateinit var apiInterface: ApiInterfaceBase

    @Named("base")
    @Inject
    lateinit var apiInterfaceBase: ApiInterface

    @Inject
    lateinit var context: Context

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    init {
        loadingVisibility.value = View.GONE
        MyApplication.application.appComponent.inject(this)
    }
}