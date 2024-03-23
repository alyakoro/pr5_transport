package com.korobeynikova.pr5_transport

data class Vehicle(
    val name: String,
    val isCar: Boolean,
    val capacity: Int,
    val axles: Int,
    val imageResId: Int? = null
)