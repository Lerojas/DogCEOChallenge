package com.androidavanzado.dogceochallenge.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidavanzado.dogceochallenge.model.BreedImageData
import com.androidavanzado.dogceochallenge.network.RetroInstance
import com.androidavanzado.dogceochallenge.network.RetroService
import retrofit2.Call
import retrofit2.Response

class BreedImageListActivityViewModel : ViewModel() {

    var breedListData : MutableLiveData<ArrayList<String>> = MutableLiveData()

    fun getListDataObserver() : MutableLiveData<ArrayList<String>> {
        return breedListData
    }

    fun makeApiCall(breedName : String){

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getBreedImageDataFromAPI(breedName)

        call.enqueue(object : retrofit2.Callback<BreedImageData>{
            override fun onResponse(call: Call<BreedImageData>, response: Response<BreedImageData>) {
                if(response.isSuccessful){
                    breedListData.postValue(response.body()?.message as ArrayList<String>?)
                }
                else{
                    breedListData.postValue(null)
                }
            }
            override fun onFailure(call: Call<BreedImageData>, t: Throwable) {
                breedListData.postValue(null)
            }
        })
    }
}