package com.ymlct.hometaskcleanarch.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppMetricsDto(
    val amountOfAppLaunches: Int
)