package com.ymlct.hometaskcleanarch.domain.repository

import com.ymlct.hometaskcleanarch.domain.model.AppMetrics

interface Repository {
    fun getAppMetrics(): AppMetrics?
    fun saveAppMetrics(appMetrics: AppMetrics)
}