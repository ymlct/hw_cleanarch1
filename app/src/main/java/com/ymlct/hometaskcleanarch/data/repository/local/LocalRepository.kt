package com.ymlct.hometaskcleanarch.data.repository.local
import com.ymlct.hometaskcleanarch.data.dto.AppMetricsDto
import kotlin.reflect.KClass

interface LocalRepository {
    fun saveAppMetrics(metrics: AppMetricsDto)
    fun getData(): AppMetricsDto?
}