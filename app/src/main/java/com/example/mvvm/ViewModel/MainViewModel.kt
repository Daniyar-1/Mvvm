package com.example.mvvm.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

        private var mCounter = 0

     val counter = MutableLiveData<Int>()
     val addingString = MutableLiveData<String>()

    init {
        addingString.value = ""
    }
    fun onIncrementClick(){
        ++mCounter
        counter.value = mCounter
        addingString.value += "+,"
        Log.d("ololo", addingString.value.toString())
    }

    fun onDecrementClick() {
        --mCounter
        counter.value = mCounter
        addingString.value += "-,"
        Log.d("ololo", addingString.value.toString())
    }
}