package com.androidavanzado.dogceochallenge.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class BreedImageNetworkEntity (

    @SerializedName("message")
    @Expose
    var message : ArrayList<String>,

    @SerializedName("status")
    @Expose
    var status: String
)