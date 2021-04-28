package com.androidavanzado.dogceochallenge.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidavanzado.dogceochallenge.model.BreedNameData
import com.androidavanzado.dogceochallenge.network.RetroInstance
import com.androidavanzado.dogceochallenge.network.RetroService
import retrofit2.Call
import retrofit2.Response

class BreedNameListActivityViewModel : ViewModel() {

    var breedListData : MutableLiveData<ArrayList<String>> = MutableLiveData()

    fun getListDataObserver() :  MutableLiveData<ArrayList<String>> {
        return breedListData
    }

    fun makeApiCall(){

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getBreedNameDataFromAPI()

        call.enqueue(object : retrofit2.Callback<BreedNameData>{
            override fun onResponse(call: Call<BreedNameData>, response: Response<BreedNameData>) {
                if(response.isSuccessful){
                    breedListData.postValue(response.body()?.message as ArrayList<String>?)
                }
                else{
                    breedListData.postValue(null)
                }
            }
            override fun onFailure(call: Call<BreedNameData>, t: Throwable) {
                breedListData.postValue(null)
            }
        })
    }
}