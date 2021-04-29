package com.androidavanzado.dogceochallenge.data.network

import com.androidavanzado.dogceochallenge.data.model.BreedImageNetworkEntity
import com.androidavanzado.dogceochallenge.data.model.BreedNameNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroService {

    @GET("api/breeds/list")
    fun getBreedNameDataFromAPI() : retrofit2.Call<BreedNameNetworkEntity>

    @GET("api/breed/{breed_name}/images")
    fun getBreedImageDataFromAPI(@Path(value = "breed_name", encoded = true) breedName :  String) : retrofit2.Call<BreedImageNetworkEntity>
}