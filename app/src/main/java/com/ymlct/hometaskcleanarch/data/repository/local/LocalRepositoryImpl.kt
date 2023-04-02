package com.ymlct.hometaskcleanarch.data.repository.local

import android.content.SharedPreferences
import com.ymlct.hometaskcleanarch.data.dto.AppMetricsDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocalRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : LocalRepository {

    private val appMetricsDtoKey = "AppMetricsDto"
    private val emptyString = ""

    override fun saveAppMetrics(metrics: AppMetricsDto) {
        val json = Json.encodeToString(metrics)
        sharedPreferences.edit().putString(appMetricsDtoKey, json).apply()
    }

    override fun getData(): AppMetricsDto? {
        val json = sharedPreferences.getString(appMetricsDtoKey, emptyString)
        return if (json == null || json.isEmpty()) null
        else Json.decodeFromString(json)
    }
}