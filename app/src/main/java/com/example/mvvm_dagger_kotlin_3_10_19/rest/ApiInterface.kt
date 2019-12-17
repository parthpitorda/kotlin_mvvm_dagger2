package com.example.mvvm_dagger_kotlin_3_10_19.rest

import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.LoginResponse
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.PhotosResponse
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.UserResponse
import io.reactivex.Observable
import retrofit2.http.*


interface ApiInterface {

    @GET("users?")
    fun getUsersData(@Query("page") page: Int): Observable<UserResponse>

    @POST("login")
    @FormUrlEncoded
    fun getLogin(@Field("email") email: String, @Field("password") pass: String):Observable<LoginResponse>



}

interface ApiInterfaceBase {
    @GET("photos")
    fun getPhotos():Observable<List<PhotosResponse>>
}