package com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.LoginResponse
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel : BaseViewModel() {
    private lateinit var disposable: Disposable
    val loginResponse: MutableLiveData<Int> = MutableLiveData()


    override fun onCleared() {
        super.onCleared()
        if (::disposable.isInitialized) disposable.dispose()
    }

    private fun getData(userName: String, userPass: String) {
        disposable = apiInterfaceBase.getLogin(userName, userPass).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(response: LoginResponse) {
        loginResponse.value = 1
    }

    private fun onRetrievePostListError() {
        errorMessage.value = "error"
    }

    fun onLogin(userName: String, userPass: String) {
        getData(userName, userPass)
    }
}