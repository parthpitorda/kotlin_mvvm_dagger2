package com.example.mvvm_dagger_kotlin_3_10_19.rest.vo

data class PhotosResponse(//https://jsonplaceholder.typicode.com/photos
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)