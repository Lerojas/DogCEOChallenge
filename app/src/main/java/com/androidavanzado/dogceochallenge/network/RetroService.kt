package com.androidavanzado.dogceochallenge.network

import com.androidavanzado.dogceochallenge.model.BreedNameData
import com.androidavanzado.dogceochallenge.model.BreedImageData
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroService {

    @GET("api/breeds/list")
    fun getBreedNameDataFromAPI() : retrofit2.Call<BreedNameData>

    @GET("api/breed/{breed_name}/images")
    fun getBreedImageDataFromAPI(@Path(value = "breed_name", encoded = true) breedName :  String) : retrofit2.Call<BreedImageData>
}