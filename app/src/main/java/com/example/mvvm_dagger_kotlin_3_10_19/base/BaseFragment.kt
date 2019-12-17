package com.example.mvvm_dagger_kotlin_3_10_19.base

import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.example.mvvm_dagger_kotlin_3_10_19.database.UserDao
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var preferences: SharedPreferences
    @Inject
    lateinit var editor: SharedPreferences.Editor
    @Inject
    lateinit var userDao: UserDao

}