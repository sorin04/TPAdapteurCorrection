package com.michael.retrofitcall

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.michael.retrofitcall.databinding.ActivityMainBinding
import com.michael.retrofitcall.pojo.EtuItem
import com.michael.retrofitcall.view_model.EtuViewModel
import com.michael.retrofitcall.retrofit.Interface_Retrofit
import com.michael.retrofitcall.retrofit.Api_Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: EtuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EtuViewModel::class.java)
        binding.lifecycleOwner = this@MainActivity

        binding.liveData = viewModel
        viewModel.initData()

        binding.buttonEtudiant.setOnClickListener {
            getEtudiant()
        }
        binding.buttonAllEtudiants.setOnClickListener {
            getAllEtudiants()
        }
    }

    fun getEtudiant() {
        Api_Retrofit.api.getEtudiant().enqueue(object : Callback<EtuItem> {
            override fun onResponse(call: Call<EtuItem?>, response: Response<EtuItem?>) {
                if (response.isSuccessful) {
                    Log.d("response", response.body().toString())
                    viewModel.initData()
                    response.body()?.let {
                        viewModel.updateData(it as EtuItem)
                    }
                }
            }

            override fun onFailure(call: Call<EtuItem?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }



    fun getAllEtudiants(){
        Api_Retrofit.api.getAllEtudiants().enqueue(object : Callback<ArrayList<EtuItem>>{
            override fun onResponse(call: Call<ArrayList<EtuItem>?>, response: Response<ArrayList<EtuItem>?>) {
                if (response.isSuccessful) {
                    Log.d("response", response.body().toString())
                    viewModel.initData()
                    response.body()?.let {
                        viewModel.updateData(it)
                    }
                }
            }
            override fun onFailure(call: Call<ArrayList<EtuItem>?>, t: Throwable) {
                Log.e( "onFailure", "onFailure: ${t.toString()}", )
            }
        })
    }
}