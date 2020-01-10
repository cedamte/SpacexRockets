package com.example.spacexlaunches.data


import com.google.gson.annotations.SerializedName

data class Isp(
    @SerializedName("sea_level")
    val seaLevel: Int,
    @SerializedName("vacuum")
    val vacuum: Int
)