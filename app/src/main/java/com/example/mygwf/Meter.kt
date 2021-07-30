package com.example.mygwf

import com.google.gson.annotations.SerializedName

data class Meter(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("mp_name")
    val mp_name: String,
    @SerializedName(value = "meter_id")
    val meter_id: String,
    @SerializedName("meter_type")
    val meter_type: String,
    @SerializedName("comm_mod_type")
    val comm_mod_type: String,
    @SerializedName("comm_mod_serial")
    val comm_mod_serial: String,
    @SerializedName("last_entry")
    val last_entry: String,
    @SerializedName("volume")
    val volume: Double,
    @SerializedName("battery_lifetime")
    val battery_lifetime: Int,
    /*@SerializedName("state")
    val state: State*/

)
