package com.androidavanzado.dogceochallenge.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BreedNameNetworkEntity (

    @SerializedName("message")
    @Expose
    var message : ArrayList<String>,

    @SerializedName("status")
    @Expose
    var status: String
)