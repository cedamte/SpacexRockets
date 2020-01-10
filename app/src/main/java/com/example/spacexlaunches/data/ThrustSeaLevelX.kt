package com.example.spacexlaunches.data


import com.google.gson.annotations.SerializedName

data class ThrustSeaLevelX(
    @SerializedName("kN")
    val kN: Int,
    @SerializedName("lbf")
    val lbf: Int
)