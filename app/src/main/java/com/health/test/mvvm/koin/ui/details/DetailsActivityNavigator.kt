package com.health.test.mvvm.koin.ui.details

import com.health.test.mvvm.koin.model.weather.WeatherReport

/**
 * Raghavendra on 10:15 2018-12-19
 */
interface DetailsActivityNavigator {
    fun hideProgress()
    fun setData(weatherReportList: ArrayList<WeatherReport>)
}