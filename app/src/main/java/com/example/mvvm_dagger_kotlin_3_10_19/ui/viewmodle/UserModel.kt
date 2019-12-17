package com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle

import androidx.lifecycle.MutableLiveData
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.Datum

class UserModel : BaseViewModel() {

    private val email = MutableLiveData<String>()
    private val fName = MutableLiveData<String>()
    private val lName = MutableLiveData<String>()
    private val thumb = MutableLiveData<String>()

    fun bind(userDatum: Datum) {
        this.email.value = userDatum.email
        this.fName.value = userDatum.first_name
        this.lName.value = userDatum.last_name
        this.thumb.value = userDatum.avatar
    }


    fun getThumbUrl():MutableLiveData<String>{
        return thumb
    }

    fun getFname():MutableLiveData<String>{
        return fName
    }

    fun getLname():MutableLiveData<String>{
        return lName
    }

    fun getEmail():MutableLiveData<String>{
        return email
    }
}