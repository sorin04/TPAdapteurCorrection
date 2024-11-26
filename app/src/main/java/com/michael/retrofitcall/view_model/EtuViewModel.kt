package com.michael.retrofitcall.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michael.retrofitcall.pojo.EtuItem

class EtuViewModel: ViewModel() {
    private val _data = MutableLiveData<ArrayList<EtuItem>>()
    val data: LiveData<ArrayList<EtuItem>> = _data

    fun initData() {
        val initialData = arrayListOf<EtuItem>()
        _data.value = initialData
    }

    // Ajouter un nouvel élément aux données existantes
    fun updateData(newData: EtuItem) {
        val currentData = _data.value ?: arrayListOf()
        newData.let {
            currentData.add(it)
        }
        _data.value = currentData
    }

    // Ajouter un nouvel élément aux données existantes
    fun updateData(arNewData: ArrayList<EtuItem>) {
        var currentData = arNewData
        _data.value = currentData
    }



}