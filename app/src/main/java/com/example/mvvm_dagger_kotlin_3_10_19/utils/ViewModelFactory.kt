package com.example.mvvm_dagger_kotlin_3_10_19.utils


import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.LoginViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle.UserViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "posts").build()
//            @Suppress("UNCHECKED_CAST")
//            return UserViewModel(db.postDao()) as T
//        }

        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel() as T
        }

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")

    }
}