package com.example.mvvm_dagger_kotlin_3_10_19.di

import com.example.mvvm_dagger_kotlin_3_10_19.ui.activity.MainActivity
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseActivity
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.base.MyApplication
import com.example.mvvm_dagger_kotlin_3_10_19.di.module.AppModule
import com.example.mvvm_dagger_kotlin_3_10_19.di.module.NetWorkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetWorkModule::class, AppModule::class])
abstract class AppComponent {

    abstract fun inject(myApplication: MyApplication)
    abstract fun inject(mainActivity: MainActivity)
    abstract fun inject(baseActivity: BaseActivity)
    abstract fun inject(baseViewModel: BaseViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun netWorkmodule(netWorkModule: NetWorkModule): Builder
        fun appModule(appModule: AppModule): Builder
    }

}