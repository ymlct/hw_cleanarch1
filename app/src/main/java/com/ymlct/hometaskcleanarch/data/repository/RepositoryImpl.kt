package com.ymlct.hometaskcleanarch.data.repository

import com.ymlct.hometaskcleanarch.data.mapper.toDto
import com.ymlct.hometaskcleanarch.data.mapper.toModel
import com.ymlct.hometaskcleanarch.data.repository.local.LocalRepository
import com.ymlct.hometaskcleanarch.domain.repository.Repository
import com.ymlct.hometaskcleanarch.domain.model.AppMetrics
import javax.inject.Inject

class RepositoryImpl(
    private val localRepository: LocalRepository
): Repository {

    override fun getAppMetrics(): AppMetrics? =
        localRepository.getData()?.toModel()


    override fun saveAppMetrics(appMetrics: AppMetrics) =
        localRepository.saveAppMetrics(appMetrics.toDto())
}