package com.example.mvvm_dagger_kotlin_3_10_19.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.example.mvvm_dagger_kotlin_3_10_19.database.AppDatabase
import com.example.mvvm_dagger_kotlin_3_10_19.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application,private val appDatabase: AppDatabase) {

    @Provides
    @Singleton
    internal fun providerApplication():Application{
        return application
    }

    @Provides
    @Singleton
    internal fun providerContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun providerResource(context: Context):Resources{
        return context.resources
    }

    @Provides
    @Singleton
    internal fun providerPref(): SharedPreferences{
        return application.applicationContext.getSharedPreferences("MyApp",0)
    }

    @Provides
    @Singleton
    internal fun providerPrefEditor(): SharedPreferences.Editor{
        return application.applicationContext.getSharedPreferences("MyApp",0).edit()
    }

    @Provides
    @Singleton
    internal fun providerAPPDatabase():AppDatabase{
        return appDatabase
    }

    @Provides
    @Singleton
    internal fun providerUserDao(): UserDao{
        return appDatabase.userDao()
    }
}