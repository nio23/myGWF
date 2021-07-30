package com.example.mygwf

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("continuous_flow")
    val continuous_flow: Boolean,
    @SerializedName("broken_pipe")
    val broken_pipe: Boolean,
    @SerializedName("battery_low")
    val battery_low: Boolean,
    @SerializedName("backflow")
    val backflow: Boolean,
    @SerializedName("communication_error")
    val communication_error: Boolean,
    @SerializedName("parsing_error")
    val parsing_error: Boolean,
    @SerializedName("encoder_error")
    val encoder_error: Boolean
)
