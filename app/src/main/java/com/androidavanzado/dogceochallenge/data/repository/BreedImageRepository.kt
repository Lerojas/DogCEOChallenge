package com.androidavanzado.dogceochallenge.data.repository

import androidx.lifecycle.MutableLiveData
import com.androidavanzado.dogceochallenge.data.mappers.BreedImageNetworkMapper
import com.androidavanzado.dogceochallenge.data.model.BreedImageNetworkEntity
import com.androidavanzado.dogceochallenge.data.network.RetroInstance
import com.androidavanzado.dogceochallenge.data.network.RetroService
import retrofit2.Call
import retrofit2.Response

class BreedImageRepository constructor(
    private val breedImageNetworkMapper: BreedImageNetworkMapper){

    val liveData = MutableLiveData<ArrayList<String>?>()

    fun getData(breedName: String) {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getBreedImageDataFromAPI(breedName)

        call.enqueue(
            object : retrofit2.Callback<BreedImageNetworkEntity> {
                override fun onResponse(call: Call<BreedImageNetworkEntity>, response: Response<BreedImageNetworkEntity>) {
                    if (response.isSuccessful) {
                        val breedImageNetworkEntity = response.body()?.let { BreedImageNetworkEntity(it.message, response.body()!!.status) }
                        liveData.value = breedImageNetworkEntity?.let {
                            breedImageNetworkMapper.mapFromEntity(
                                it
                            ).message
                        }
                    }
                    else {
                        liveData.value = null
                    }
                }

                override fun onFailure(call: Call<BreedImageNetworkEntity>, t: Throwable) {
                    liveData.value = null
                }
            })
    }
}