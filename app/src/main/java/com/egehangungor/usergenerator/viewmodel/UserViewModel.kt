package com.egehangungor.usergenerator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val userLiveData = MutableLiveData<Any>()

    fun getDataFromRoom(){
        //val user = User("Ege","12335566","Male","12344554","25","wwww.ss.com")
        //userLiveData.value = user
    }
}