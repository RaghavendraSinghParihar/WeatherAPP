package com.health.test.mvvm.koin.ui.home

import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.base.BaseViewModel
import com.utils.SchedulerProvider

/**
 * Raghavendra on 10:13 2018-12-19
 */
class HomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
        BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {
}

