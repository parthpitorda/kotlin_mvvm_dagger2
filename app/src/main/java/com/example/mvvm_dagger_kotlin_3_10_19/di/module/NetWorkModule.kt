package com.example.mvvm_dagger_kotlin_3_10_19.di.module

import com.example.mvvm_dagger_kotlin_3_10_19.rest.ApiInterface
import com.example.mvvm_dagger_kotlin_3_10_19.rest.ApiInterfaceBase
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@Suppress("unused")
object NetWorkModule {

    @Provides
    internal fun providerApiInterface(@Named("photo") retrofit: Retrofit): ApiInterfaceBase {
        return retrofit.create(ApiInterfaceBase::class.java)
    }

    @Provides
    internal fun providerApiInterfaceBase(@Named("base") retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Named("base")
    internal fun providerRetrofitInterface(): Retrofit {

        return Retrofit.Builder().baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    //not working
    @Provides
    @Named("photo")
    internal fun providerRetrofitInterFace2(): Retrofit{
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}