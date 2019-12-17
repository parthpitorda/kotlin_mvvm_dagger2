package com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.PhotosResponse

class PhotoModel : BaseViewModel() {

    private val albumId = MutableLiveData<Int>()
    private val id = MutableLiveData<Int>()
    private val title = MutableLiveData<String>()
    private val url = MutableLiveData<String>()
    private val thumbnailUrl = MutableLiveData<String>()

    fun bind(photosResponse: PhotosResponse) {
        albumId.value = photosResponse.albumId
        id.value = photosResponse.id
        title.value = photosResponse.title
        url.value = photosResponse.url
        thumbnailUrl.value = photosResponse.thumbnailUrl
    }

    fun getThumbUrl():MutableLiveData<String>{
        return thumbnailUrl
    }

    fun getTitle():MutableLiveData<String>{
        return title
    }

    fun getUrl():MutableLiveData<String>{
        return url
    }

    fun getId():MutableLiveData<Int> {
        return id
    }
}