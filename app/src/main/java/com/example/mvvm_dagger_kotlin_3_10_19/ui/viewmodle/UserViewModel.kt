package com.example.mvvm_dagger_kotlin_3_10_19.ui.viewmodle

import android.app.Dialog
import android.content.Intent
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.mvvm_dagger_kotlin_3_10_19.R
import com.example.mvvm_dagger_kotlin_3_10_19.base.BaseViewModel
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.Datum
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.PhotosResponse
import com.example.mvvm_dagger_kotlin_3_10_19.rest.vo.UserResponse
import com.example.mvvm_dagger_kotlin_3_10_19.ui.activity.DetailActivity
import com.example.mvvm_dagger_kotlin_3_10_19.ui.activity.LoginActivity
import com.example.mvvm_dagger_kotlin_3_10_19.ui.adapter.UserAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlin.collections.ArrayList

class UserViewModel : BaseViewModel() {

    private lateinit var disposable: Disposable
    private lateinit var disposable2: Disposable
    val userAdapter: UserAdapter = UserAdapter({ item -> doClick(item) })

    var responseViewFlipper: List<Datum> = ArrayList()
    var responsePhoto: List<PhotosResponse> = ArrayList()
    val errorClickListener = View.OnClickListener { getData() }


    init {
        getData()
    }

    fun getData() {

        disposable2 = apiInterface.getPhotos().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrevePhotListSuccess(result) },
                { error -> onRetrievePostListError() }
            )

        disposable = apiInterfaceBase.getUsersData(1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    override fun onCleared() {
        super.onCleared()
        if (::disposable.isInitialized) disposable.dispose()
        if (::disposable2.isInitialized) disposable2.dispose()
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(userData: UserResponse) {
        responseViewFlipper = userData.data

    }

    private fun onRetrevePhotListSuccess(photosResponse: List<PhotosResponse>) {
        responsePhoto = photosResponse
        userAdapter.updateUserList(photosResponse)
        userAdapter.notifyDataSetChanged()
    }

    private fun onRetrievePostListError() {
        errorMessage.value = "error"
    }

    private fun onRetrievePhotoListError() {
        errorMessage.value = "error"
    }

    private fun doClick(item: Any) {
        context.startActivity(
            Intent(context, DetailActivity::class.java).putExtra("data", item.toString())
        )
        Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
    }
}