package com.example.spacexlaunches.data


import com.google.gson.annotations.SerializedName

data class Rockets(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("boosters")
    val boosters: Int,
    @SerializedName("company")
    val company: String,
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("engines")
    val engines: Engines,
    @SerializedName("flickr_images")
    val flickrImages: List<String>,
    @SerializedName("rocket_id")
    val rocketId: String,
    @SerializedName("rocket_name")
    val rocketName: String,
    @SerializedName("rocket_type")
    val rocketType: String
)