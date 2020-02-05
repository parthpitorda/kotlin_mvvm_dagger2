package com.example.mvvm_dagger_kotlin_3_10_19.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.service.autofill.UserData
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm_dagger_kotlin_3_10_19.database.UserDao
import com.example.mvvm_dagger_kotlin_3_10_19.rest.ApiInterface
import javax.inject.Inject
import javax.inject.Named

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var preferences: SharedPreferences
    @Inject
    lateinit var editor: SharedPreferences.Editor
    @Inject 
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inject BaseActivity for dagger magic methods
        MyApplication.application.appComponent.inject(this)
    }
}