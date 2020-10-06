package com.egehangungor.usergenerator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class FeedViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    val userError = MutableLiveData<Boolean>()
    val userLoading = MutableLiveData<Boolean>()


    fun refreshData(){

        userError.value = false
        userLoading.value = false

    }


}