package com.ymlct.hometaskcleanarch.data.mapper

import com.ymlct.hometaskcleanarch.data.dto.AppMetricsDto
import com.ymlct.hometaskcleanarch.domain.model.AppMetrics

fun AppMetrics.toDto(): AppMetricsDto {
    return AppMetricsDto(
        amountOfAppLaunches = amountOfAppLaunches
    )
}

fun AppMetricsDto.toModel(): AppMetrics {
    return AppMetrics(
        amountOfAppLaunches = amountOfAppLaunches
    )
}