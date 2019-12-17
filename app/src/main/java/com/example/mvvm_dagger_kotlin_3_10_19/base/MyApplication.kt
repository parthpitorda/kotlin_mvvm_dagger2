package com.example.mvvm_dagger_kotlin_3_10_19.base

import android.app.Application
import androidx.room.Room
import com.example.mvvm_dagger_kotlin_3_10_19.database.AppDatabase
import com.example.mvvm_dagger_kotlin_3_10_19.di.AppComponent
import com.example.mvvm_dagger_kotlin_3_10_19.di.DaggerAppComponent
import com.example.mvvm_dagger_kotlin_3_10_19.di.module.AppModule
import com.example.mvvm_dagger_kotlin_3_10_19.di.module.NetWorkModule

class MyApplication:Application() {

    open lateinit var appComponent: AppComponent

    companion object{
        lateinit var application: MyApplication
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        appComponent = DaggerAppComponent.builder()
            .netWorkmodule(NetWorkModule)
            .appModule(AppModule(application, Room.databaseBuilder(this,
                AppDatabase::class.java, "MVVM_DEMO")
                .allowMainThreadQueries().build())).build()

        appComponent.inject(this)

    }
}