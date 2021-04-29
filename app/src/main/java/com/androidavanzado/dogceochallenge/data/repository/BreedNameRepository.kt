package com.androidavanzado.dogceochallenge.data.repository

import androidx.lifecycle.MutableLiveData
import com.androidavanzado.dogceochallenge.data.mappers.BreedNameNetworkMapper
import com.androidavanzado.dogceochallenge.data.model.BreedNameNetworkEntity
import com.androidavanzado.dogceochallenge.data.network.RetroInstance
import com.androidavanzado.dogceochallenge.data.network.RetroService
import retrofit2.Call
import retrofit2.Response

class BreedNameRepository constructor(
    private val breedNameNetworkMapper: BreedNameNetworkMapper){
    val liveData = MutableLiveData<ArrayList<String>?>()

    fun getData() {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getBreedNameDataFromAPI()

        call.enqueue(
        object : retrofit2.Callback<BreedNameNetworkEntity> {
            override fun onResponse(call: Call<BreedNameNetworkEntity>,
                                    response: Response<BreedNameNetworkEntity>) {
                if (response.isSuccessful) {
                    val breedNameNetworkEntity = response.body()?.let { BreedNameNetworkEntity(it.message, response.body()!!.status) }
                    liveData.value = breedNameNetworkEntity?.let {
                        breedNameNetworkMapper.mapFromEntity(
                            it
                        ).message
                    }
                }
                else {
                    liveData.value = null
                }
            }

            override fun onFailure(call: Call<BreedNameNetworkEntity>, t: Throwable) {
                liveData.value = null
            }
        })
    }
}