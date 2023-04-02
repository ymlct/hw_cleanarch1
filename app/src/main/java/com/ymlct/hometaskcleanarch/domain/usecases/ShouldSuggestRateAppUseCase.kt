package com.ymlct.hometaskcleanarch.domain.usecases

import android.util.Log
import com.ymlct.hometaskcleanarch.domain.model.AppMetrics
import com.ymlct.hometaskcleanarch.domain.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class ShouldSuggestRateAppUseCase @Inject constructor(
    private val repository: Repository
    ) {

    suspend operator fun invoke(): Boolean {
        return coroutineScope {
            val result = async {
                repository.getAppMetrics()
            }
            val metrics = result.await()

            if (metrics == null) {
                repository.saveAppMetrics(AppMetrics(amountOfAppLaunches = 2))
                Log.e("","ShouldSuggestRateAppUseCase: create new AppMetrics")
                false
            } else {
                repository.saveAppMetrics(AppMetrics(amountOfAppLaunches = metrics.amountOfAppLaunches + 1))
                (metrics.amountOfAppLaunches == 2
                        || (metrics.amountOfAppLaunches - 2) % 4 == 0).apply {
                    Log.e("","ShouldSuggestRateAppUseCase: amountOfAppLaunches = ${metrics.amountOfAppLaunches}, $this")
                }
            }
        }
    }
}