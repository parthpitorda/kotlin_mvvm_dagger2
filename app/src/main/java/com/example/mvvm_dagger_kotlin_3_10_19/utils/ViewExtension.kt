package com.example.mvvm_dagger_kotlin_3_10_19.utils

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}